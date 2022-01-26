package service;

import dto.ProyectoDTO;
import mapper.ProyectoMapper;
import dao.Proyecto;
import repository.RepoProyecto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProyectoService extends BaseService<Proyecto, Long, RepoProyecto> {

    ProyectoMapper mapper = new ProyectoMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public ProyectoService(RepoProyecto repository) {
        super(repository);
    }
    /**
     * Mapea todos los proyectos a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<ProyectoDTO>> getAllProyectos() throws SQLException {
        return mapper.toDTO(this.getAll());
    }
    /**
     * Mapea un proyecto por id a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProyectoDTO getProyectoById(Long id) throws SQLException {

            return mapper.toDTO(this.getById(id).get());
    }
    /**
     * Mapea el save de proyecto a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProyectoDTO postProyecto(ProyectoDTO proyectoDTO) throws SQLException {
            Optional<Proyecto> res = this.save(mapper.fromDTO(proyectoDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el update de proyecto a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) throws SQLException {
            Optional<Proyecto> res = this.update(mapper.fromDTO(proyectoDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el delete de proyecto a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProyectoDTO deleteProyecto(ProyectoDTO proyectoDTO) throws SQLException {
            Optional<Proyecto> res = this.delete(mapper.fromDTO(proyectoDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Muestra los tres proyectos mas caros y el salario de los trabajadores
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
//Operacion 5
    public List<Object> getProyectosMasCaros() throws SQLException {
        RepoProyecto repo = new RepoProyecto();
        return repo.getProyectosMasCaros().orElseThrow(()->(new SQLException("IssueService -> Error al encontrar los proyectos mas caros y los salarios")));
    }
}
