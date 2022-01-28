package mapper;

import dto.ProgramadorDTO;
import dao.Programador;

public class ProgramadorMapper extends BaseMapper<Programador, ProgramadorDTO> {

    @Override
    public Programador fromDTO(ProgramadorDTO item) {
        Programador programador=new Programador();
        programador.setId(item.getId());
        programador.setNombre(item.getNombre());
        programador.setFechaAlta(item.getFechaAlta());
        programador.setSalario(item.getSalario());
        programador.setTecnologias(item.getTecnologias());
        programador.setDepartamento(item.getDepartamento());
        programador.setCommits(item.getCommits());
        programador.setIssues(item.getIssues());
        programador.setProyectosParticipa(item.getProyectosParticipa());
        return programador;
    }

    @Override
    public ProgramadorDTO toDTO(Programador item) {
        return ProgramadorDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .fechaAlta(item.getFechaAlta())
                .salario(item.getSalario())
                .tecnologias(item.getTecnologias())
                .departamento(item.getDepartamento())
                .proyectosParticipa(item.getProyectosParticipa())
                .commits(item.getCommits())
                .issues(item.getIssues())
                .build();
    }
}
