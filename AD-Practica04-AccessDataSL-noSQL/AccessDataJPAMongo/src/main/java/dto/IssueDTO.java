package dto;

import dao.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {

    private long id;
    private String titulo;
    private String texto;
    private Timestamp fecha;
    private Boolean resuelta;
    private JefeProyecto jefe;
    private List<Programador> programadores;
    private Repositorio repositorio;
    private Commit commit;

    @Override
    public String toString(){
        return "Issue{id="+this.id
                +", titulo="+this.titulo
                +", texto="+this.texto
                +", fecha="+this.fecha
                +", resuelta="+this.resuelta
                +", jefe="+this.jefe.getId()
                +", repositorio="+this.repositorio.getId()
                +", commit="+this.commit.getId()
                +", programadores="+programadores.stream().map(Programador::getId).collect(Collectors.toList())
                +"}";
    }
}
