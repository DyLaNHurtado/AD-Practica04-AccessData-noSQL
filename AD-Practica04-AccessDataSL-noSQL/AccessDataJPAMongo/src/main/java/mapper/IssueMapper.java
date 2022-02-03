package mapper;

import dao.Issue;
import dto.IssueDTO;

/**
 * Mapper de Issue
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class IssueMapper extends BaseMapper<Issue, IssueDTO> {
    @Override
    public Issue fromDTO(IssueDTO item) {
        return new Issue(item.getId(),item.getTexto(),
                item.getTexto(),item.getFecha(),item.getResuelta(),
                item.getJefe(),item.getProgramadores(),
                item.getRepositorio(),item.getCommit());
    }

    @Override
    public IssueDTO toDTO(Issue item) {
        return IssueDTO.builder()
                .id(item.getId())
                .titulo(item.getTexto())
                .texto(item.getTexto())
                .fecha(item.getFecha())
                .resuelta(item.getResuelta())
                .programadores(item.getProgramadores())
                .jefe(item.getJefe())
                .commit(item.getCommit())
                .repositorio(item.getRepositorio())
                .build();
    }
}