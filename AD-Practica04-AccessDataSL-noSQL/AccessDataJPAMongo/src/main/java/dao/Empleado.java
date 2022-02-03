package dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Clase padre Empleado
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@MappedSuperclass
public abstract class Empleado {

    private long id;
    private String nombre;
    private Timestamp fechaAlta;
    private Double salario;
    private List<String> tecnologias;

    /**
     * Constructor vacío
     */
    public Empleado() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable=false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Basic
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    @Basic
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    @ElementCollection(fetch = FetchType.EAGER)
    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }
}
