package dto;

import dao.Commit;
import dao.Issue;
import dao.Programador;
import dao.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO de Repositorio
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositorioDTO {
    private long id;
    private String nombre;
    private Timestamp fechaCreacion;
    private Proyecto proyecto;
    private List<Issue> issues;
    private List<Commit> commits;

    @Override
    public String toString(){
        return "Repositorio{id="+this.id
                +", nombre="+this.nombre
                +", fecha_creacion="+this.fechaCreacion
                +"}";
    }
}
