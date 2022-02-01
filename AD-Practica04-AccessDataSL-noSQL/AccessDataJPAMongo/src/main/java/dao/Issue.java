package dao;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="issue")
@NamedQueries({
        @NamedQuery(name = "Issue.getAll", query = "SELECT i FROM dao.Issue i")
})
@AllArgsConstructor
public class Issue {

    private long id;
    private String titulo;
    private String texto;
    private Timestamp fecha;
    private Boolean resuelta;
    private JefeProyecto jefe;
    private List<Programador> programadores;
    private Repositorio repositorio;
    private Commit commit;

    public Issue() {
    }

    public Issue(String titulo, String texto, Timestamp fecha, Boolean resuelta) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.resuelta = resuelta;
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
    @Basic
    @Column(name="resuelta")
    public Boolean getResuelta() {
        return resuelta;
    }

    public void setResuelta(Boolean resuelta) {
        this.resuelta = resuelta;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jefe_id", referencedColumnName = "id")
    public JefeProyecto getJefe() {
        return jefe;
    }

    public void setJefe(JefeProyecto jefe) {
        this.jefe = jefe;
    }

    @ManyToMany(mappedBy = "issues",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Programador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String toString(){
        return "Issue{id="+this.id
                +", titulo="+this.titulo
                +", texto="+this.texto
                +", fecha="+this.fecha
                +", resuelta="+this.resuelta
                +", programadores="+this.programadores.stream().map(Programador::getId).collect(Collectors.toList())
                +", repositorio="+this.repositorio.getId()
                +", jefe="+this.jefe.getId()
                +", commit="+this.commit.getId()
                +"}";
    }
}
