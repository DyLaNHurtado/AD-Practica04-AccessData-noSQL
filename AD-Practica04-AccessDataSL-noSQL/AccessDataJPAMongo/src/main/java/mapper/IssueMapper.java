package mapper;

import dao.Commit;
import dao.Departamento;
import dao.Issue;
import dto.CommitDTO;
import dto.DepartamentoDTO;
import dto.IssueDTO;

public class IssueMapper extends BaseMapper<Issue, IssueDTO> {
    @Override
    public Issue fromDTO(IssueDTO item) {
        return Issue.builder()
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