package service;

import dto.ProyectoDTO;
import mapper.ProyectoMapper;
import dao.Proyecto;
import repository.RepoProyecto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Proyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ProyectoService extends BaseService<Proyecto, Long, RepoProyecto> {

    ProyectoMapper mapper = new ProyectoMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository ProyectoService
     */
    public ProyectoService(RepoProyecto repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Proyecto a ProyectoDTO
     * @return Optional<List<ProyectoDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<ProyectoDTO>> getAllProyectos() throws SQLException {
        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Proyecto a ProyectoDTO a partir de una ID
     * @param id de Proyecto
     * @return ProyectoDTO
     * @throws SQLException Exception
     */
    public ProyectoDTO getProyectoById(Long id) throws SQLException {

            return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Proyecto de save a ProyectoDTO
     * @param proyectoDTO ProyectoDTO
     * @return ProyectoDTO
     * @throws SQLException Exception
     */
    public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) throws SQLException {
            Optional<Proyecto> res = this.save(mapper.fromDTO(proyectoDTO));
                return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Proyecto a ProyectoDTO
     * @param proyectoDTO ProyectoDTO
     * @return ProyectoDTO
     * @throws SQLException Exception
     */
    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) throws SQLException {
            Optional<Proyecto> res = this.update(mapper.fromDTO(proyectoDTO));
                return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de Proyecto a ProyectoDTO
     * @param proyectoDTO ProyectoDTO
     * @return ProyectoDTO
     * @throws SQLException Exception
     */
    public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) throws SQLException {
            Optional<Proyecto> res = this.delete(mapper.fromDTO(proyectoDTO));
                return mapper.toDTO(res.get());
    }
}
