package mapper;

import dto.DepartamentoDTO;
import dao.Departamento;

public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO> {

    @Override
    public Departamento fromDTO(DepartamentoDTO item) {
        return Departamento.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .presupuestoAnual(item.getPresupuestoAnual())
                .jefeDepartamento(item.getJefeDepartamento())
                .proyDesarrollo(item.getProyDesarrollo())
                .proyFinalizados(item.getProyFinalizados())
                .trabajadores(item.getTrabajadores())
                .build();
    }

    @Override
    public DepartamentoDTO toDTO(Departamento item) {
        return DepartamentoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .presupuestoAnual(item.getPresupuestoAnual())
                .jefeDepartamento(item.getJefeDepartamento())
                .proyDesarrollo(item.getProyDesarrollo())
                .proyFinalizados(item.getProyFinalizados())
                .trabajadores(item.getTrabajadores())
                .build();
    }
}

