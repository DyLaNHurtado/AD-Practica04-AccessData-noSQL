package mapper;

import dao.Commit;
import dto.CommitDTO;

/**
 * Mapper de Commit
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class CommitMapper extends BaseMapper<Commit, CommitDTO> {

    /**
     * Devuelve un Commit a partir de un CommitDTO
     * @param item CommitDTO
     * @return Commit
     */
    @Override
    public Commit fromDTO(CommitDTO item) {
        return new Commit(item.getId(),item.getTitulo(),
                item.getTexto(),item.getFecha(),item.getIssue(),
                item.getRepositorio(),item.getProgramador());
    }

    /**
     * Devuelve un CommitDTO a partir de un Commit
     * @param item Commit
     * @return CommitDTO
     */
    @Override
    public CommitDTO toDTO(Commit item) {
        return CommitDTO.builder()
                .id(item.getId())
                .titulo(item.getTitulo())
                .texto(item.getTexto())
                .fecha(item.getFecha())
                .issue(item.getIssue())
                .repositorio(item.getRepositorio())
                .programador(item.getProgramador())
                .build();
    }
}
