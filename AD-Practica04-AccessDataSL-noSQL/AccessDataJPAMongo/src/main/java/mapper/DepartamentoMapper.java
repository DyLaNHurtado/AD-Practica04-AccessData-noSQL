package mapper;

import dto.DepartamentoDTO;
import dao.Departamento;

import java.util.List;
import java.util.Optional;

public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO> {
    @Override
    public Departamento fromDTO(DepartamentoDTO item) {
        return Departamento.builder()
                .idDepartamento(item.getIdDepartamento())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .presupuestoAnual(item.getPresupuestoAnual())
                .build();
    }

    @Override
    public DepartamentoDTO toDTO(Departamento item) {
        return DepartamentoDTO.builder()
                .idDepartamento(item.getIdDepartamento())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .presupuestoAnual(item.getPresupuestoAnual())
                .build();
    }
}

