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

    /**
     * Constructor con inyección de dependencias
     * @param repository JefeDepartamentoService
     */
    public JefeDepartamentoService(RepoJefeDepartamento repository) {
        super(repository);
    }

    /**
     * Mapea una lista de JefeDepartamento a JefeDepartamentoDTO
     * @return Optional<List<JefeDepartamentoDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<JefeDepartamentoDTO>> getAllJefeDepartamento() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un JefeDepartamento a JefeDepartamentoDTO a partir de una ID
     * @param id de JefeDepartamento
     * @return JefeDepartamentoDTO
     * @throws SQLException Exception
     */
    public JefeDepartamentoDTO getJefeDepartamentoById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el JefeDepartamento de save a JefeDepartamentoDTO
     * @param jefeDepartamentoDTO JefeDepartamentoDTO
     * @return JefeDepartamentoDTO
     * @throws SQLException Exception
     */
    public JefeDepartamentoDTO postJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) throws SQLException {
        Optional<JefeDepartamento> res = this.save(mapper.fromDTO(jefeDepartamentoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de JefeDepartamento a JefeDepartamentoDTO
     * @param jefeDepartamentoDTO JefeDepartamento
     * @return JefeDepartamentoDTO
     * @throws SQLException Exception
     */
    public JefeDepartamentoDTO updateJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) throws SQLException {
        Optional<JefeDepartamento> res = this.update(mapper.fromDTO(jefeDepartamentoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de JefeDepartamento a JefeDepartamentoDTO
     * @param jefeDepartamentoDTO JefeDepartamentoDTO
     * @return JefeDepartamentoDTO
     * @throws SQLException Exception
     */
    public JefeDepartamentoDTO deleteJefeDepartamento(JefeDepartamentoDTO jefeDepartamentoDTO) throws SQLException {
        Optional<JefeDepartamento> res = this.delete(mapper.fromDTO(jefeDepartamentoDTO));
        return mapper.toDTO(res.get());
    }
}