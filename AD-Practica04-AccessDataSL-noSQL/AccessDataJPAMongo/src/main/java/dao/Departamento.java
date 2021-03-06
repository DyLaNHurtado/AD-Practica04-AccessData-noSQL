package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Departamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "departamento")
@NamedQueries({
        @NamedQuery(name = "Departamento.getAll", query = "SELECT c FROM dao.Departamento c")
})
public class Departamento implements Serializable {

    private long id;
    private String nombre;
    private JefeDepartamento jefeDepartamento;
    private List<Proyecto> proyFinalizados = new ArrayList<>();
    private List<Proyecto> proyDesarrollo = new ArrayList<>();
    private Double presupuesto;
    private Double presupuestoAnual;
    private List<Programador> trabajadores = new ArrayList<>();

    /**
     * Constructor para comprobaciones
     * @param nombre
     * @param presupuesto
     * @param presupuestoAnual
     */
    public Departamento(String nombre, Double presupuesto, Double presupuestoAnual) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.presupuestoAnual = presupuestoAnual;
    }

    public Departamento(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long idDepartamento) {
        this.id = idDepartamento;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToOne(cascade=CascadeType.ALL)
    public JefeDepartamento getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(JefeDepartamento jefe) {
        this.jefeDepartamento = jefe;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Proyecto> getProyFinalizados() {
        return proyFinalizados;
    }

    public void setProyFinalizados(List<Proyecto> proyFinalizados) {
        this.proyFinalizados = proyFinalizados;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Proyecto> getProyDesarrollo() {
        return proyDesarrollo;
    }

    public void setProyDesarrollo(List<Proyecto> proyDesarrollo) {
        this.proyDesarrollo = proyDesarrollo;
    }

    @Basic
    @Column(name = "presupuesto")
    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Basic
    @Column(name = "presupuesto_anual")
    public Double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(Double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departamento", cascade = CascadeType.REMOVE)
    public List<Programador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Programador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public String toString() {
        return "Departamento{\n" +
                "idDepartamento='" + id + '\'' +
                ", \nnombre='" + nombre + '\'' +
                ", \njefe='" + jefeDepartamento + '\'' +
                ", \nproyFinalizados=" + proyFinalizados +
                ", \nproyDesarrollo=" + proyDesarrollo +
                ", \npresupuesto=" + presupuesto +
                ", \npresupuestoAnual=" + presupuestoAnual +
                ", \ntrabajadores=" + trabajadores +
                "\n}";
    }
}
