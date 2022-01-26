package dto;

import dao.Commit;
import dao.JefeProyecto;
import dao.Programador;
import dao.Repositorio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

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

}
