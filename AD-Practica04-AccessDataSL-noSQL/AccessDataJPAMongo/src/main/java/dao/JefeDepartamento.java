package dao;

import javax.persistence.*;

@Embeddable
public class JefeDepartamento extends Empleado{

    private Departamento departamento;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable=false)
    public long getId(){
        return super.getId();
    }

    @OneToOne(mappedBy = "jefeDepartamento")
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
