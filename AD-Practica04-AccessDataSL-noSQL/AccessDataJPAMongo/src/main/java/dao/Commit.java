package dao;

import lombok.Builder;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "commit")
@NamedQueries({
        @NamedQuery(name = "Commit.getAll", query = "SELECT c FROM dao.Commit c")
})
@Builder
public class Commit {

    private long id;
    private String titulo;
    private String texto;
    private Timestamp fecha;
    private Issue issue;
    private Repositorio repositorio;
    private Programador programador;

    public Commit() {
    }

    //testing
    public Commit(long id, String titulo, String texto, Timestamp fecha) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
    }

    public Commit(String titulo, String texto, Timestamp fecha) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name="titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Basic
    @Column(name="texto",nullable = false)
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    @Basic
    @Column(name="fecha",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="issue",referencedColumnName = "issue")
    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @ManyToOne
    @JoinColumn(name = "repositorio_id", referencedColumnName = "id", nullable = false)
    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @ManyToOne
    @JoinColumn(name = "programador_id", referencedColumnName = "id", nullable = false)
    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }
}
