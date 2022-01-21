package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor

@Entity
@Table(name = "programador")
@NamedQueries({
        @NamedQuery(name = "Programador.getAll", query = "SELECT c FROM dao.Programador c"),
        @NamedQuery(name = "Programador.getByIdDepartamento", query = "SELECT c FROM dao.Programador c WHERE c.departamento=departamento"),
})
public class Programador extends Empleado implements Serializable {

    private Departamento departamento;
    private List<Proyecto> proyectosParticipa;
    private List<Commit> commits;
    private List<Issue> issues;

    public Programador() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable=false)
    public long getId(){
        return super.getId();
    }

    @ManyToOne
    @JoinColumn(name = "idDepartamento",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "participaciones",
            joinColumns = @JoinColumn(name = "idProyecto",unique = true),
            inverseJoinColumns = @JoinColumn(name = "idProgramador",unique = true,foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    )
    public List<Proyecto> getProyectosParticipa() {
        return proyectosParticipa;
    }
    public void setProyectosParticipa(List<Proyecto> proyectosParticipa) {
        this.proyectosParticipa = proyectosParticipa;
    }

    @Override
    public String toString() {
        return "Programador{\n" +
                ", \ndepartamento=" + departamento.getIdDepartamento() +
                ", \nproyectosParticipa=" + proyectosParticipa +
                "\n}";
    }
}
