package service;

import dao.JefeProyecto;
import dto.JefeProyectoDTO;
import mapper.JefeProyectoMapper;
import repository.RepoJefeProyecto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JefeProyectoService extends BaseService<JefeProyecto, Long, RepoJefeProyecto>{

    private JefeProyectoMapper mapper=new JefeProyectoMapper();

    public JefeProyectoService(RepoJefeProyecto repository) {
        super(repository);
    }

    /**
     * Mapea todos los jefes de proyecto a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<JefeProyectoDTO>> getAllJefeProyecto() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un jefe de proyecto por id a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeProyectoDTO getJefeProyectoById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el save de jefe de proyecto a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeProyectoDTO postJefeProyecto(JefeProyectoDTO jefeProyectoDTO) throws SQLException {
        Optional<JefeProyecto> res = this.save(mapper.fromDTO(jefeProyectoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de jefe de proyecto a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeProyectoDTO updateJefeProyecto(JefeProyectoDTO jefeProyectoDTO) throws SQLException {
        Optional<JefeProyecto> res = this.update(mapper.fromDTO(jefeProyectoDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de jefe de proyecto a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public JefeProyectoDTO deleteJefeProyecto(JefeProyectoDTO jefeProyectoDTO) throws SQLException {
        Optional<JefeProyecto> res = this.delete(mapper.fromDTO(jefeProyectoDTO));
        return mapper.toDTO(res.get());
    }
}
