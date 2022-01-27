package dto;

import dao.Issue;
import dao.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JefeProyectoDTO {
    private long id;
    private String nombre;
    private Timestamp fechaAlta;
    private Double salario;
    private List<String> tecnologias;
    private Proyecto proyecto;
    private List<Issue> issues;

    @Override
    public String toString(){
        return "JefeProyecto{id="+this.id
                +", nombre="+this.nombre
                +", fecha="+this.fechaAlta
                +", salario="+this.salario
                +", proyecto="+this.proyecto.getId()
                +", tecnologias="+this.tecnologias
                +", issues="+issues.stream().map(Issue::getId).collect(Collectors.toList())
                +"}";
    }
}
