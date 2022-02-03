package service;

import dto.DepartamentoDTO;
import mapper.DepartamentoMapper;
import dao.Departamento;
import repository.RepoDepartamento;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Departamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class DepartamentoService extends BaseService<Departamento, Long, RepoDepartamento> {

    DepartamentoMapper mapper = new DepartamentoMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository DepartamentoService
     */
    public DepartamentoService(RepoDepartamento repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Departamento a DepartamentoDTO
     * @return Optional<List<DepartamentoDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<DepartamentoDTO>> getAllDepartamentos() throws SQLException {
        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Departamento a DepartamentoDTO a partir de una ID
     * @param id de Departamento
     * @return DepartamentoDTO
     * @throws SQLException Exception
     */
    public DepartamentoDTO getDepartamentoById(Long id) throws SQLException {
            return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Departamento de save a DepartamentoDTO
     * @param departamentoDTO DepartamentoDTO
     * @return DepartamentoDTO
     * @throws SQLException Exception
     */
    public DepartamentoDTO postDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
            Optional<Departamento> res = this.save(mapper.fromDTO(departamentoDTO));
                return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Departamento a DepartamentoDTO
     * @param departamentoDTO DepartamentoDTO
     * @return DepartamentoDTO
     * @throws SQLException Exception
     */
    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
            Optional<Departamento> res = this.update(mapper.fromDTO(departamentoDTO));
                return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de Departamento a DepartamentoDTO
     * @param departamentoDTO DepartamentoDTO
     * @return DepartamentoDTO
     * @throws SQLException Exception
     */
    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
            Optional<Departamento> res = this.delete(mapper.fromDTO(departamentoDTO));
                return mapper.toDTO(res.get());
    }
}