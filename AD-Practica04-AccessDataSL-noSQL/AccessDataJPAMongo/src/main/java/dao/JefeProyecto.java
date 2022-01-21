package dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class JefeProyecto extends Empleado{

    private Proyecto proyecto;
    private List<Issue> issues;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable=false)
    public long getId(){
        return super.getId();
    }

    @OneToOne
    public Proyecto getProyecto(){
        return proyecto;
    }
    public void setProyecto(Proyecto proyecto){
        this.proyecto=proyecto;
    }

    @OneToMany
    public List<Issue> getIssues() {
        return issues;
    }
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
