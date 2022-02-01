package dao;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="jefe_proyecto")
@NamedQueries({
        @NamedQuery(name = "JefeProyecto.getAll", query = "SELECT jp FROM dao.JefeProyecto jp")
})
public class JefeProyecto extends Empleado{

    private Proyecto proyecto;
    private List<Issue> issues;

    public JefeProyecto() {
    }

    @OneToOne(mappedBy = "jefe",cascade = CascadeType.ALL)
    public Proyecto getProyecto(){
        return proyecto;
    }
    public void setProyecto(Proyecto proyecto){
        this.proyecto=proyecto;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jefe", cascade = CascadeType.ALL)
    public List<Issue> getIssues() {
        return issues;
    }
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String jefeProyectoCompleto(){
        return "JefeProyecto{id="+super.getId()
                +", nombre="+super.getNombre()
                +", fechaAlta="+super.getFechaAlta()
                +", salario="+super.getSalario()
                +", tecnologias="+super.getTecnologias()
                +", issues="+this.issues
                +"}";
    }
}
