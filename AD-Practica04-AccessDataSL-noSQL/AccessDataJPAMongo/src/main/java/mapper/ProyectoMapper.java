package mapper;

import dto.ProyectoDTO;
import dao.Proyecto;

import java.util.Optional;

public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {

    @Override
    public Proyecto fromDTO(ProyectoDTO item) {
        return Proyecto.builder()
                .idProyecto(item.getIdProyecto())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .fechaInicio(item.getFechaInicio())
                .fechaFin(item.getFechaFin())
                .build();
    }

    @Override
    public ProyectoDTO toDTO(Proyecto item) {
        return ProyectoDTO.builder()
                .idProyecto(item.getIdProyecto())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .fechaInicio(item.getFechaInicio())
                .fechaFin(item.getFechaFin())
                //.tecnologias(item.getTecnologias())
                //.departamento(item.getDepartamento())
                //.programadores(item.getProgramadores())
                .build();
    }
}
