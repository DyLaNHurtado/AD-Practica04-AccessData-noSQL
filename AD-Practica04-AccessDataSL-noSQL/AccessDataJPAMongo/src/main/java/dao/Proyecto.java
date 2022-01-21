package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor

@Entity
@Table(name = "proyecto")
@NamedQueries({
        @NamedQuery(name = "Proyecto.getAll", query = "SELECT c FROM dao.Proyecto c"),
        @NamedQuery(name = "Proyecto.getByIdDepartamento", query = "SELECT c FROM dao.Proyecto c WHERE c.departamento.idDepartamento=:idDepartamento"),
})

public class Proyecto implements Serializable {
    private long idProyecto;
    private String nombre;
    private Double presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<String> tecnologias = new ArrayList<>();
    private Departamento departamento;
    private List<Programador> programadores = new ArrayList<>();

    public Proyecto() {
    }

    public Proyecto(long idProyecto) {
        this.idProyecto= idProyecto;
    }

    @Id
    @Column(name="idProyecto",nullable = false)
    public long getIdProyecto() {
        return idProyecto;
    }
    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Basic
    @Column(name="nombre",nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name="fechaInicio",nullable = false)
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    @Basic
    @Column(name="fechaFin",nullable = false)
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @ManyToOne()
    @JoinColumn(name="idDepartamento",referencedColumnName = "idDepartamento",columnDefinition = "departamento", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @ManyToMany(mappedBy = "proyectosParticipa")
    public List<Programador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    @Override
    public String toString() {
        List<String> idProgramadores = new ArrayList<>();
        programadores.forEach(x -> idProgramadores.add(x.getId())); //da error
        return "Proyecto{\n" +
                "idProyecto='\n" + idProyecto + '\'' +
                ", \nnombre='" + nombre + '\'' +
                ", \npresupuesto=" + presupuesto +
                ", \nfechaInicio=" + fechaInicio +
                ", \nfechaFin=" + fechaFin +
                ", \ntecnologias=" + tecnologias +
                ", \ndepartamento=" + departamento.getIdDepartamento() +
                ", \nprogramadores=" + idProgramadores +
                "\n}";
    }
}
