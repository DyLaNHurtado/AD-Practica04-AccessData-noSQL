package dao;

import lombok.Builder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="issue")
@NamedQueries({
        @NamedQuery(name = "Issue.getAll", query = "SELECT i FROM dao.Issue i")
})
@Builder
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
    @Temporal(TemporalType.TIMESTAMP)
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

    @ManyToOne
    @JoinColumn(name = "jefe_id", referencedColumnName = "id", nullable = false)
    public JefeProyecto getJefe() {
        return jefe;
    }

    public void setJefe(JefeProyecto jefe) {
        this.jefe = jefe;
    }

    //Como se hace un ManyToMany
    //https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "issues")

    public List<Programador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    @ManyToOne
    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @OneToOne
    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}
