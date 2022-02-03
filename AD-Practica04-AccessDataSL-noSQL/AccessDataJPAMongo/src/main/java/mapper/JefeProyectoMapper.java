package mapper;

import dao.JefeProyecto;
import dto.JefeProyectoDTO;

/**
 * Mapper de JefeProyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class JefeProyectoMapper extends BaseMapper<JefeProyecto, JefeProyectoDTO> {

    /**
     * Devuelve un JefeProyecto a partir de un JefeProyectoDTO
     * @param item JefeProyectoDTO
     * @return JefeProyecto
     */
    @Override
    public JefeProyecto fromDTO(JefeProyectoDTO item) {
        JefeProyecto jefe = new JefeProyecto();
        jefe.setId(item.getId());
        jefe.setNombre(item.getNombre());
        jefe.setFechaAlta(item.getFechaAlta());
        jefe.setSalario(item.getSalario());
        jefe.setTecnologias(item.getTecnologias());
        jefe.setProyecto(item.getProyecto());
        jefe.setIssues(item.getIssues());
        return jefe;
    }

    /**
     * Devuelve un JefeProyectoDTO a partir de un JefeProyecto
     * @param item JefeProyecto
     * @return JefeProyectoDTO
     */
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
