package mapper;

import dto.ProgramadorDTO;
import dao.Programador;

public class ProgramadorMapper extends BaseMapper<Programador, ProgramadorDTO> {

    @Override
    public Programador fromDTO(ProgramadorDTO item) {
        return Programador.builder()
                .idProgramador(item.getIdProgramador())
                .nombre(item.getNombre())
                .fechaAlta(item.getFechaAlta())
                //.departamento(item.getDepartamento())
                //.proyectosParticipa(item.getProyectosParticipa())
                //.tecnologias(item.getTecnologias())
                .salario(item.getSalario())
                .jefeDepartamento(item.isJefeDepartamento())
                .jefeProyecto(item.isJefeProyecto())
                .build();
    }

    @Override
    public ProgramadorDTO toDTO(Programador item) {
        return ProgramadorDTO.builder()
                .idProgramador(item.getId())
                .nombre(item.getNombre())
                .fechaAlta(item.getFechaAlta())
                .salario(item.getSalario())
                .jefeDepartamento(item.isJefeDepartamento())
                .jefeProyecto(item.isJefeProyecto())
                .build();
    }
}
