package mapper;

import dao.JefeProyecto;
import dto.JefeProyectoDTO;

public class JefeProyectoMapper extends BaseMapper<JefeProyecto, JefeProyectoDTO>{
    @Override
    public JefeProyecto fromDTO(JefeProyectoDTO item) {
        JefeProyecto jefe=new JefeProyecto();
        jefe.setId(item.getId());
        jefe.setNombre(item.getNombre());
        jefe.setFechaAlta(item.getFechaAlta());
        jefe.setSalario(item.getSalario());
        jefe.setTecnologias(item.getTecnologias());
        jefe.setProyecto(item.getProyecto());
        jefe.setIssues(item.getIssues());
        return jefe;
    }

    @Override
    public JefeProyectoDTO toDTO(JefeProyecto item) {
        return JefeProyectoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .fechaAlta(item.getFechaAlta())
                .salario(item.getSalario())
                .tecnologias(item.getTecnologias())
                .proyecto(item.getProyecto())
                .issues(item.getIssues())
                .build();
    }
}
