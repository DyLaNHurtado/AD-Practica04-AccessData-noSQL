package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * DAO de Repositorio
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@Entity
@Table(name="repositorio")
@NamedQueries({
        @NamedQuery(name = "Repositorio.getAll", query = "SELECT r FROM dao.Repositorio r")
})
@AllArgsConstructor
@NoArgsConstructor
public class Repositorio {

    private long id;
    private String nombre;
    private Timestamp fechaCreacion;
    private Proyecto proyecto;
    private List<Issue> issues;
    private List<Commit> commits;

    /**
     * Constructor para comprobaciones
     * @param nombre
     * @param fechaCreacion
     */
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
    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name="fecha_creacion")
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @OneToOne(mappedBy = "repositorio", cascade = CascadeType.ALL)
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

    @Override
    public String toString(){
        return "Proyecto{id="+this.id
                +", nombre="+this.nombre
                +", fechaCreacion="+this.fechaCreacion
                +", proyecto="+this.proyecto
                +", issues="+this.issues
                +", commits="+this.commits
                +"}";
    }
}
