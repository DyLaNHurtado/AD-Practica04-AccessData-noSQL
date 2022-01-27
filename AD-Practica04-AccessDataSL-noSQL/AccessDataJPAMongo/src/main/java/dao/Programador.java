package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor

@Entity
@Table(name = "programador")
@NamedQueries({
        @NamedQuery(name = "Programador.getAll", query = "SELECT c FROM dao.Programador c")
})
public class Programador extends Empleado implements Serializable {

    private Departamento departamento;
    private List<Proyecto> proyectosParticipa;
    private List<Commit> commits;
    private List<Issue> issues;

    public Programador() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return super.getId();
    }

    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", nullable = false)
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    @ManyToMany
    @JoinTable(
            name = "participacion",
            joinColumns = @JoinColumn(name = "programador_id"),
            inverseJoinColumns = @JoinColumn(name = "proyecto_id"))

    public List<Proyecto> getProyectosParticipa() {
        return proyectosParticipa;
    }

    public void setProyectosParticipa(List<Proyecto> proyectosParticipa) {
        this.proyectosParticipa = proyectosParticipa;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "programador", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    @ManyToMany
    @JoinTable(
            name = "asignacion",
            joinColumns = @JoinColumn(name = "programador_id"),
            inverseJoinColumns = @JoinColumn(name = "issue_id"))

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString(){
        return "Programador{id="+super.getId()
                +", nombre="+super.getNombre()
                +", fecha="+super.getFechaAlta()
                +", salario="+super.getSalario()
                +", tecnologias="+super.getTecnologias()
                +", departamento="+this.departamento.getId()
                +", proyectos="+this.proyectosParticipa.stream().map(Proyecto::getId).collect(Collectors.toList())
                +", issues="+this.issues.stream().map(Issue::getId).collect(Collectors.toList())
                +", commits="+this.commits.stream().map(Commit::getId).collect(Collectors.toList())
                +"}";
    }
}
