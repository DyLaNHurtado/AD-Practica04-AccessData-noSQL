package service;

import repository.RepoTecnologia;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TecnologiaService extends BaseService<Tecnologia, String, RepoTecnologia> {

    TecnologiaMapper mapper = new TecnologiaMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public TecnologiaService(RepoTecnologia repository) {
        super(repository);
    }
    /**
     * Mapea todas las tecnologias a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<TecnologiaDTO>> getAllTecnologias() throws SQLException {
        return mapper.toDTO(this.getAll());
    }
    /**
     * Mapea todas una tecnologia por ID
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public TecnologiaDTO getTecnologiaById(String id) throws SQLException {
            return mapper.toDTO(this.getById(id).get());
    }
    /**
     * Mapea un insert de una tecnologia
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public TecnologiaDTO postTecnologia(TecnologiaDTO tecnologiaDTO) throws SQLException {
            Optional<Tecnologia> res = this.save(mapper.fromDTO(tecnologiaDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el update de una tecnologia
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public TecnologiaDTO updateTecnologia(TecnologiaDTO tecnologiaDTO) throws SQLException {
            Optional<Tecnologia> res = this.update(mapper.fromDTO(tecnologiaDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el delete de una tecnologia a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public TecnologiaDTO deleteTecnologia(TecnologiaDTO tecnologiaDTO) throws SQLException {

            Optional<Tecnologia> res = this.delete(mapper.fromDTO(tecnologiaDTO));
                return mapper.toDTO(res.get());
    }

}
