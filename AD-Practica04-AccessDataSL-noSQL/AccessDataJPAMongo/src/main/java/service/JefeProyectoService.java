package service;

import dao.JefeProyecto;
import dto.JefeProyectoDTO;
import mapper.JefeProyectoMapper;
import repository.RepoJefeProyecto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de JefeProyecto
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class JefeProyectoService extends BaseService<JefeProyecto, Long, RepoJefeProyecto>{

    private JefeProyectoMapper mapper=new JefeProyectoMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository JefeProyectoService
     */
    public JefeProyectoService(RepoJefeProyecto repository) {
        super(repository);
    }

    /**
     * Mapea una lista de JefeProyecto a JefeProyectoDTO
     * @return Optional<List<JefeProyectoDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<JefeProyectoDTO>> getAllJefeProyecto() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un JefeProyecto a JefeProyectoDTO a partir de una ID
     * @param id JefeProyecto
     * @return JefeProyectoDTO
     * @throws SQLException Exception
     */
    public JefeProyectoDTO getJefeProyectoById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el JefeProyecto de save a JefeProyectoDTO
     * @param jefeProyectoDTO JefeProyectoDTO
     * @return JefeProyectoDTO
     * @throws SQLException Exception
     */
    public JefeProyectoDTO postJefeProyecto(JefeProyectoDTO jefeProyectoDTO) throws SQLException {
        Optional<JefeProyecto> res = this.save(mapper.fromDTO(jefeProyectoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de JefeProyecto a JefeProyectoDTO
     * @param jefeProyectoDTO JefeProyectoDTO
     * @return JefeProyectoDTO
     * @throws SQLException Exception
     */
    public JefeProyectoDTO updateJefeProyecto(JefeProyectoDTO jefeProyectoDTO) throws SQLException {
        Optional<JefeProyecto> res = this.update(mapper.fromDTO(jefeProyectoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de JefeProyecto a JefeProyectoDTO
     * @param jefeProyectoDTO JefeProyectoDTO
     * @return JefeProyectoDTO
     * @throws SQLException Exception
     */
    public JefeProyectoDTO deleteJefeProyecto(JefeProyectoDTO jefeProyectoDTO) throws SQLException {
        Optional<JefeProyecto> res = this.delete(mapper.fromDTO(jefeProyectoDTO));
        return mapper.toDTO(res.get());
    }
}
