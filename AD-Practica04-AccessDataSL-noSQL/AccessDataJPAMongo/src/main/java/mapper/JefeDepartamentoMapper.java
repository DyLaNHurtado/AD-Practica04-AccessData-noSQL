package mapper;

import dao.JefeDepartamento;
import dto.JefeDepartamentoDTO;

/**
 * Mapper de JefeDepartamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class JefeDepartamentoMapper extends BaseMapper<JefeDepartamento, JefeDepartamentoDTO> {

    /**
     * Devuelve un JefeDepartamento a partir de un JefeDepartamentoDTO
     * @param item JefeDepartamentoDTO
     * @return JefeDepartamento
     */
    @Override
    public JefeDepartamento fromDTO(JefeDepartamentoDTO item) {
        JefeDepartamento jefe = new JefeDepartamento();
        jefe.setId(item.getId());
        jefe.setNombre(item.getNombre());
        jefe.setFechaAlta(item.getFechaAlta());
        jefe.setSalario(item.getSalario());
        jefe.setTecnologias(item.getTecnologias());
        jefe.setDepartamento(item.getDepartamento());
        return jefe;
    }

    /**
     * Devuelve un JefeDepartamentoDTO a partir de un JefeDepartamento
     * @param item JefeDepartamento
     * @return JefeDepartamentoDTO
     */
    @Override
    public JefeDepartamentoDTO toDTO(JefeDepartamento item) {
        return JefeDepartamentoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .fechaAlta(item.getFechaAlta())
                .salario(item.getSalario())
                .tecnologias(item.getTecnologias())
                .departamento(item.getDepartamento())
                .build();
    }
}
