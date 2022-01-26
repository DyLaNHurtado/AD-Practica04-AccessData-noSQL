package dao;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="repositorio")
@NamedQueries({
        @NamedQuery(name = "Repositorio.getAll", query = "SELECT r FROM dao.Repositorio r")
})
@AllArgsConstructor
public class Repositorio {

    private long id;
    private String nombre;
    private Timestamp fechaCreacion;
    private Proyecto proyecto;
    private List<Issue> issues;
    private List<Commit> commits;

    public Repositorio() {}

    public Repositorio(String nombre, Timestamp fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable=false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name="fecha_creacion", nullable=false)
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    //mappedBy = al nombre de la variable repositorio dentro de proyecto
    @OneToOne(mappedBy = "repositorio")
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "repositorio", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "repositorio", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

}
