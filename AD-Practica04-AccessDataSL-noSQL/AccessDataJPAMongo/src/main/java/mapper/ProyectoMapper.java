package mapper;

import dto.ProyectoDTO;
import dao.Proyecto;

public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {

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
