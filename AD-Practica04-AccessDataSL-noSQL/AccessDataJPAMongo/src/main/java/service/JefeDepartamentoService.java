package service;

import dao.JefeDepartamento;
import dto.JefeDepartamentoDTO;
import mapper.JefeDepartamentoMapper;
import repository.RepoJefeDepartamento;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de JefeDepartamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class JefeDepartamentoService extends BaseService<JefeDepartamento, Long, RepoJefeDepartamento>{

    private JefeDepartamentoMapper mapper=new JefeDepartamentoMapper();

    public JefeDepartamentoService(RepoJefeDepartamento repository) {
        super(repository);
    }

    /**
     * Mapea todos los jefes de departamento a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<JefeDepartamentoDTO>> getAllJefeDepartamento() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un jefe de departamento por id a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeDepartamentoDTO getJefeDepartamentoById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el save de jefe de departamento a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeDepartamentoDTO postJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) throws SQLException {
        Optional<JefeDepartamento> res = this.save(mapper.fromDTO(jefeDepartamentoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de jefe de departamento a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeDepartamentoDTO updateJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) throws SQLException {
        Optional<JefeDepartamento> res = this.update(mapper.fromDTO(jefeDepartamentoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de jefe de departamento a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeDepartamentoDTO deleteJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) throws SQLException {
        Optional<JefeDepartamento> res = this.delete(mapper.fromDTO(jefeDepartamentoDTO));
        return mapper.toDTO(res.get());
    }
}