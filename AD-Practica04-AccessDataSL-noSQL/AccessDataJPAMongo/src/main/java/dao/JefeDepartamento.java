package dao;

import javax.persistence.*;

@Entity
@Table(name = "departamento")
@NamedQueries({
        @NamedQuery(name = "JefeDepartamento.getAll", query = "SELECT jd FROM dao.JefeDepartamento jd")
})
public class JefeDepartamento extends Empleado{

    private Departamento departamento;

    public JefeDepartamento(){
    }

    @OneToOne(mappedBy = "jefeDepartamento")
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
