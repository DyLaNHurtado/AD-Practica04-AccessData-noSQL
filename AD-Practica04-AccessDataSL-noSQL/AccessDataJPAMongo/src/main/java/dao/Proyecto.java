package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor

@Entity
@Table(name = "proyecto")
@NamedQueries({
        @NamedQuery(name = "Proyecto.getAll", query = "SELECT c FROM dao.Proyecto c")
})
public class Proyecto implements Serializable {
    private long id;
    private String nombre;
    private Double presupuesto;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private List<String> tecnologias = new ArrayList<>();
    private JefeProyecto jefe;
    private Departamento departamento;
    private Repositorio repositorio;
    private List<Programador> programadores = new ArrayList<>();

    public Proyecto() {
    }

    public Proyecto(String nombre, Double presupuesto, Timestamp fechaInicio, Timestamp fechaFin) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getId() {
        return id;
    }

    public void setId(long idProyecto) {
        this.id = idProyecto;
    }

    @Basic
    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name = "fechaInicio", nullable = false)
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "fechaFin", nullable = false)
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @ElementCollection //Igual que @Basic pero para colecciones
    @Column(name = "tecnologias", nullable = false)
    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public JefeProyecto getJefe() {
        return jefe;
    }

    public void setJefe(JefeProyecto jefe) {
        this.jefe = jefe;
    }

    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", nullable = false)
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
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
        return "Proyecto{\n" +
                "idProyecto='\n" + id + '\'' +
                ", \nnombre='" + nombre + '\'' +
                ", \npresupuesto=" + presupuesto +
                ", \nfechaInicio=" + fechaInicio +
                ", \nfechaFin=" + fechaFin +
                ", \ntecnologias=" + tecnologias +
                ", \ndepartamento=" + departamento.getId() +
                ", \njefe=" + jefe.getId() +
                ", \nprogramadores=" + programadores.stream().map(Programador::getId).collect(Collectors.toList()) +
                ", \nrepositorio=" + repositorio.getId() +
                "\n}";
    }


}
