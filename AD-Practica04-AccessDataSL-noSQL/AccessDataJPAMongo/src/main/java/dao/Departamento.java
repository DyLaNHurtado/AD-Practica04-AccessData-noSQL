package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder

@Entity
@Table(name = "departamento")
@NamedQueries({
        @NamedQuery(name = "Departamento.getAll", query = "SELECT c FROM dao.Departamento c")
})
public class Departamento implements Serializable {

    private long idDepartamento;
    private String nombre;
    private JefeDepartamento jefeDepartamento;
    private List<Proyecto> proyFinalizados = new ArrayList<>();
    private List<Proyecto> proyDesarrollo = new ArrayList<>();
    private Double presupuesto;
    private Double presupuestoAnual;
    private List<Programador> trabajadores = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String nombre, Double presupuesto, Double presupuestoAnual) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.presupuestoAnual = presupuestoAnual;
    }

    public Departamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Basic
    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Embedded
    public JefeDepartamento getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(JefeDepartamento jefe) {
        this.jefeDepartamento = jefe;
    }


    /*
    Que hace el orphanRemoval=true??:

    Marca la entidad "secundaria" que se eliminará
    cuando ya no se haga referencia a ella desde la entidad "principal",
    por ejemplo, cuando elimine la entidad secundaria(proyecto) de la colección
    correspondiente de la entidad principal(departamento).
    */


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
    @Column(name = "presupuesto", nullable = false)
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
                "idDepartamento='" + idDepartamento + '\'' +
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
