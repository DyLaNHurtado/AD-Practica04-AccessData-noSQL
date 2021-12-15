package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor

@Entity
@Table(name = "programador")
@NamedQueries({
        @NamedQuery(name = "Programador.getAll", query = "SELECT c FROM dao.Programador c"),
        @NamedQuery(name = "Programador.getByIdDepartamento", query = "SELECT c FROM dao.Programador c WHERE c.departamento=departamento"),
})
public class Programador implements Serializable {
    private String idProgramador;
    private String nombre;
    private LocalDate fechaAlta;


    private Departamento departamento;

    private List<Proyecto> proyectosParticipa;


    private List<Tecnologia> tecnologias;

    private Double salario;
    private boolean jefeDepartamento;
    private boolean jefeProyecto;


    public Programador() {

    }

    public Programador(String idProgramador) {
        this.idProgramador = idProgramador;
    }

    @Id
    @Column(nullable = false)
    public String getIdProgramador() {
        return idProgramador;
    }
    public void setIdProgramador(String idProgramador) {
        this.idProgramador = idProgramador;
    }

    @Basic
    @Column(nullable = false)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(nullable = false)
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
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
    @ManyToMany(mappedBy = "programadores")
    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }
    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    @Basic
    @Column(nullable = false)
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Basic
    @Column(name="esJefeDepartamento",nullable = false)
    public boolean isJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(boolean jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }
    @Basic
    @Column(name="esJefeProyecto",nullable = false)
    public boolean isJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(boolean jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public String toStringProductividad() {
        List<String> proyectos = new ArrayList<>();
                proyectosParticipa.forEach(x->proyectos.add(x.getIdProyecto()));
        return "Programador{" +
                "idProgramador='" + idProgramador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", proyectosParticipa=" + proyectos +
                '}';
    }

    @Override
    public String toString() {
        return "Programador{\n" +
                "idProgramador='\n" + idProgramador + '\'' +
                ",\n nombre='" + nombre + '\'' +
                ", \nfechaAlta=" + fechaAlta +
                ", \ndepartamento=" + departamento.getIdDepartamento() +
                ", \nproyectosParticipa=" + proyectosParticipa +
                ", \ntecnologias=" + tecnologias +
                ", \nsalario=" + salario +
                ", \njefeDepartamento=" + jefeDepartamento +
                ", \njefeProyecto=" + jefeProyecto +
                "\n}";
    }
}
