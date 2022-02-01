package dto;

import dao.*;
import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ProyectoDTO {
    private long id;
    private String nombre;
    private Double presupuesto;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private List<String> tecnologias = new ArrayList<>();
    private JefeProyecto jefe;
    private Departamento departamento;
    private Repositorio repositorio;
    private List<Programador> programadores = new ArrayList<>();

    @Override
    public String toString(){
        return "Proyecto{id="+this.id
                +", nombre="+this.nombre
                +", fecha_inicio="+this.fechaInicio
                +", fecha_fin="+this.fechaFin
                +", presupuesto="+this.presupuesto
                +", departamento="+this.departamento.getId()
                +", tecnologias="+this.tecnologias
                +", programadores="+this.programadores.stream().map(Programador::getId).collect(Collectors.toList())
                +", repositorio="+this.repositorio.getId()
                +", jefe="+this.jefe.getId()
                +"}";
    }

    public String proyectoCompleto(){
        return "Proyecto{id="+this.id
                +", nombre="+this.nombre
                +", fecha_inicio="+this.fechaInicio
                +", fecha_fin="+this.fechaFin
                +", presupuesto="+this.presupuesto
                +", departamento="+this.departamento.getId()
                +", tecnologias="+this.tecnologias
                +", programadores="+this.programadores
                +", repositorio="+this.repositorio
                +", jefe="+this.jefe.jefeProyectoCompleto()
                +"}";
    }

    public String issuesAbiertas(){
        return "Proyecto{id="+this.id
                +", repositorio="+this.repositorio.getIssues().stream().map(Issue::getId).collect(Collectors.toList())
                +"}";
    }

    public String ordenarProgramadoresCommit(){
        return "Proyecto{id="+this.id
                +", programadores="+this.programadores.stream().sorted(Comparator.comparingInt(x->x.getCommits().size())).collect(Collectors.toList())
                +"}";
    }
}
