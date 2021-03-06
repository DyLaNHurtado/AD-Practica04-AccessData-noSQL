package mapper;

import dto.DepartamentoDTO;
import dao.Departamento;

/**
 * Mapper de Departamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO> {

    /**
     * Devuelve un Departamento a partir de un DepartamentoDTO
     * @param item DepartamentoDTO
     * @return Departamento
     */
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
                .trabajadores(item.getProgramadores())
                .build();
    }

    /**
     * Devuelve un DepartamentoDTO a partir de un Departamento
     * @param item Departamento
     * @return DepartamentoDTO
     */
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
                .programadores(item.getTrabajadores())
                .build();
    }
}

