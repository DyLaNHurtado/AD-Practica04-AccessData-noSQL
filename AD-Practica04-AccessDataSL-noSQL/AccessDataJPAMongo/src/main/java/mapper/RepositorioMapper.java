package mapper;

import dao.Repositorio;
import dto.RepositorioDTO;

/**
 * Mapper de Repositorio
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class RepositorioMapper  extends BaseMapper<Repositorio, RepositorioDTO> {

    /**
     * Devuelve un Repositorio a partir de un RepositorioDTO
     * @param item RepositorioDTO
     * @return Repositorio
     */
    @Override
    public Repositorio fromDTO(RepositorioDTO item) {
        return new Repositorio(item.getId(),item.getNombre(),
                item.getFechaCreacion(),item.getProyecto(),
                item.getIssues(),item.getCommits());
    }

    /**
     * Devuelve un RepositorioDTO a partir de un Repositorio
     * @param item Repositorio
     * @return RepositorioDTO
     */
    @Override
    public RepositorioDTO toDTO(Repositorio item) {
        return RepositorioDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .fechaCreacion(item.getFechaCreacion())
                .proyecto(item.getProyecto())
                .commits(item.getCommits())
                .issues(item.getIssues())
                .build();
    }
}