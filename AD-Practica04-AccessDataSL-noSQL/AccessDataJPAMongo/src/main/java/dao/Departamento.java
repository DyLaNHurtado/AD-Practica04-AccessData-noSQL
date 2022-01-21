package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import javax.transaction.Transactional;
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
    @Embedded
    private JefeDepartamento jefe;
    private List<Proyecto> proyFinalizados = new ArrayList<>();
    private List<Proyecto> proyDesarrollo = new ArrayList<>();
    private Double presupuesto;
    private Double presupuestoAnual;
    private List<Programador> trabajadores = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_departamento", nullable = false)
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

    @OneToMany
    @JoinTable(
            name = "historialJefesDep",
            joinColumns = @JoinColumn(name = "idDepartamento",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "idProgramador",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)))
    public JefeDepartamento getJefe() {
        return jefe;
    }

    public void setJefe(JefeDepartamento jefe) {
        this.jefe = jefe;
    }

    @OneToMany(mappedBy = "departamento",cascade = CascadeType.ALL)
    public List<Proyecto> getProyFinalizados() {
        return proyFinalizados;
    }

    public void setProyFinalizados(List<Proyecto> proyFinalizados) {
        this.proyFinalizados = proyFinalizados;
    }
    @OneToMany(mappedBy = "departamento",cascade = CascadeType.ALL)
    public List<Proyecto> getProyDesarrollo() {
        return proyDesarrollo;
    }

    public void setProyDesarrollo(List<Proyecto> proyDesarrollo) {
        this.proyDesarrollo = proyDesarrollo;
    }

    @Basic
    @Column(name="presupuesto",nullable = false)
    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Basic
    @Column(name="presupuesto_anual")
    public Double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(Double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    @OneToMany(mappedBy = "departamento",cascade = CascadeType.REMOVE)
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
                ", \njefe='" + jefe + '\'' +
                ", \nproyFinalizados=" + proyFinalizados +
                ", \nproyDesarrollo=" + proyDesarrollo +
                ", \npresupuesto=" + presupuesto +
                ", \npresupuestoAnual=" + presupuestoAnual +
                ", \ntrabajadores=" + trabajadores +
                "\n}";
    }
}
