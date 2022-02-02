package dto;

import dao.Issue;
import dao.Programador;
import dao.Repositorio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommitDTO {

    private long id;
    private String titulo;
    private String texto;
    private Timestamp fecha;
    private Issue issue;
    private Repositorio repositorio;
    private Programador programador;

    //testing
    public CommitDTO(String titulo, String texto, Timestamp fecha) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return "Commit{id="+this.id
                +", titulo="+this.titulo
                +", texto="+this.texto
                +", fecha="+this.fecha
                +"}";
    }
}
