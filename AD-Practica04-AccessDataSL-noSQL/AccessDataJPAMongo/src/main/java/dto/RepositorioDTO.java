package dto;

import dao.Commit;
import dao.Issue;
import dao.Proyecto;
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
public class RepositorioDTO {
    private long id;
    private String nombre;
    private Timestamp fechaCreacion;
    private Proyecto proyecto;
    private List<Issue> issues;
    private List<Commit> commits;

}
