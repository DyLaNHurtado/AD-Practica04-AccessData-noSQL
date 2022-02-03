package mapper;

import dto.ProyectoDTO;
import dao.Proyecto;

/**
 * Mapper de Proyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {

    /**
     * Devuelve un Proyecto a partir de un ProyectoDTO
     * @param item ProyectoDTO
     * @return Proyecto
     */
    @Override
    public Proyecto fromDTO(ProyectoDTO item) {
        return Proyecto.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .fechaInicio(item.getFechaInicio())
                .fechaFin(item.getFechaFin())
                .tecnologias(item.getTecnologias())
                .jefe(item.getJefe())
                .departamento(item.getDepartamento())
                .repositorio(item.getRepositorio())
                .programadores(item.getProgramadores())
                .build();
    }

    /**
     * Devuelve un ProyectoDTO a partir de un Proyecto
     * @param item Proyecto
     * @return ProyectoDTO
     */
    @Override
    public ProyectoDTO toDTO(Proyecto item) {
        return ProyectoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .fechaInicio(item.getFechaInicio())
                .fechaFin(item.getFechaFin())
                .tecnologias(item.getTecnologias())
                .jefe(item.getJefe())
                .departamento(item.getDepartamento())
                .repositorio(item.getRepositorio())
                .programadores(item.getProgramadores())
                .build();
    }
}
