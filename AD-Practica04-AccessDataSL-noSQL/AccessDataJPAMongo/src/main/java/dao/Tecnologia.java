package dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor

@Entity
@Table(name = "tecnologia")
@NamedQueries({
        @NamedQuery(name = "Tecnologia.getAll", query = "SELECT c FROM dao.Tecnologia c"),
})
public class Tecnologia implements Serializable {
    private String idTecnologia;
    private String nombre;
    private List<Programador> programadores = new ArrayList<>();
    private List<Proyecto> proyectos= new ArrayList<>();


    public Tecnologia() {

    }

    @Id
    @Column(nullable = false)
    public String getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(String idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    @Basic
    @Column(nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "conocimiento",
            joinColumns = @JoinColumn(name = "idTecnologia", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "idProgramador"))
    public List<Programador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "utilidades",
            joinColumns = @JoinColumn(name = "idTecnologia", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "idProyecto"))
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        List<String> idProgramadores = new ArrayList<>();
        programadores.forEach(x -> idProgramadores.add(x.getIdProgramador()));

        List<String> idProyectos = new ArrayList<>();
        proyectos.forEach(x -> idProyectos.add(x.getIdProyecto()));
        return "Tecnologia{\n" +
                "\nidTecnologia='" + idTecnologia + '\'' +
                ", \nnombre='" + nombre + '\'' +
                ", \nprogramadores=" + idProgramadores +
                ", \nproyectos=" + idProyectos +
                "\n}";
    }
}
