package dto;

import dao.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ProgramadorDTO {
    private long id;
    private String nombre;
    private Timestamp fechaAlta;
    private Departamento departamento;
    private List<Proyecto> proyectosParticipa;
    private List<String> tecnologias;
    private Double salario;
    private List<Commit> commits;
    private List<Issue> issues;


    @Override
    public String toString(){
        return "Programador{id="+this.id
                +", nombre="+this.nombre
                +", fecha_alta="+this.fechaAlta
                +", salario="+this.salario
                +", departamento="+this.departamento.getId()
                +", tecnologias="+this.tecnologias
                +", proyectos="+proyectosParticipa.stream().map(Proyecto::getId).collect(Collectors.toList())
                +", issues="+issues.stream().map(Issue::getId).collect(Collectors.toList())
                +", commits="+commits.stream().map(Commit::getId).collect(Collectors.toList())
                +"}";
    }

    public String programadorCompleto(){
        return "Programador{id="+this.id
                +", nombre="+this.nombre
                +", fecha_alta="+this.fechaAlta
                +", salario="+this.salario
                +", departamento="+this.departamento.getId()
                +", tecnologias="+this.tecnologias
                +", proyectos="+proyectosParticipa
                +", issues="+issues
                +", commits="+commits
                +"}";
    }
}
