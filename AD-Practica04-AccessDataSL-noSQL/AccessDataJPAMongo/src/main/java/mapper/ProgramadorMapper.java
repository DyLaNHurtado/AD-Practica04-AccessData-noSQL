package mapper;

import dto.ProgramadorDTO;
import dao.Programador;

/**
 * Mapper de Programador
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ProgramadorMapper extends BaseMapper<Programador, ProgramadorDTO> {

    @Override
    public Programador fromDTO(ProgramadorDTO item) {
        Programador programador=new Programador();
        programador.setId(item.getId());
        programador.setNombre(item.getNombre());
        programador.setFechaAlta(item.getFechaAlta());
        programador.setSalario(item.getSalario());
        programador.setEmail(item.getEmail());
        programador.setPassword(item.getPassword());
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
                .email(item.getEmail())
                .password(item.getPassword())
                .tecnologias(item.getTecnologias())
                .departamento(item.getDepartamento())
                .proyectosParticipa(item.getProyectosParticipa())
                .commits(item.getCommits())
                .issues(item.getIssues())
                .build();
    }
}
