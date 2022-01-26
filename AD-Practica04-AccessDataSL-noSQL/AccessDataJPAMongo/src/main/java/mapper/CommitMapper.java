package mapper;

import dao.Commit;
import dto.CommitDTO;

public class CommitMapper extends BaseMapper<Commit, CommitDTO> {
    @Override
    public Commit fromDTO(CommitDTO item) {
        return Commit.builder()
                .id(item.getId())
                .titulo(item.getTitulo())
                .texto(item.getTexto())
                .fecha(item.getFecha())
                .issue(item.getIssue())
                .repositorio(item.getRepositorio())
                .programador(item.getProgramador())
                .build();
    }

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
