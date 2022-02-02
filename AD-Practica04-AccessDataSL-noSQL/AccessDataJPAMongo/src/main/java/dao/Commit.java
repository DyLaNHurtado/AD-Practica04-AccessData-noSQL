package dao;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "commit")
@NamedQueries({
        @NamedQuery(name = "Commit.getAll", query = "SELECT c FROM dao.Commit c")
})
@AllArgsConstructor
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
    @Column(name="texto")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    @Basic
    @Column(name="fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "repositorio_id", referencedColumnName = "id")
    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "programador_id", referencedColumnName = "id")
    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    public String toString(){
        return "Commit{id="+this.id
                +", titulo="+this.titulo
                +", texto="+this.texto
                +", fecha="+this.fecha
                +", programadores="+this.programador.getId()
                +", repositorio="+this.repositorio.getId()
                +", issue="+this.issue.getId()
                +"}";
    }
}
