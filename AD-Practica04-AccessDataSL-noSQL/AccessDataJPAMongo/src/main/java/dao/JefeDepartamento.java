package dao;

import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * DAO de JefeDepartamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@Entity
@Table(name = "jefe_departamento")
@NamedQueries({
        @NamedQuery(name = "JefeDepartamento.getAll", query = "SELECT jd FROM dao.JefeDepartamento jd")
})
@NoArgsConstructor
public class JefeDepartamento extends Empleado{

    private Departamento departamento;

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
