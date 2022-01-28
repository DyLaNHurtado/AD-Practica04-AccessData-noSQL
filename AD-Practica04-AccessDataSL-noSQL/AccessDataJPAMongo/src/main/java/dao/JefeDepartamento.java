package dao;

import javax.persistence.*;

@Entity
@Table(name = "jefe_departamento")
@NamedQueries({
        @NamedQuery(name = "JefeDepartamento.getAll", query = "SELECT jd FROM dao.JefeDepartamento jd")
})
public class JefeDepartamento extends Empleado{

    private Departamento departamento;

    public JefeDepartamento(){
    }


    @OneToOne(mappedBy = "jefeDepartamento",cascade = CascadeType.ALL)
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString(){
        return "JefeDepartamento{id="+super.getId()
                +", nombre="+super.getNombre()
                +", fecha="+super.getFechaAlta()
                +", salario="+super.getSalario()
                +", tecnologias="+super.getTecnologias()
                +", departamento="+this.departamento.getId()
                +"}";
    }
}
