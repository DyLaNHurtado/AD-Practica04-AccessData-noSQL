package service;

import dto.ProgramadorDTO;
import mapper.ProgramadorMapper;
import dao.Programador;
import repository.RepoProgramador;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Programador
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ProgramadorService extends BaseService<Programador, Long, RepoProgramador> {

    ProgramadorMapper mapper = new ProgramadorMapper();

    /**
     * Constructor con inyección de dependencias
     * @param repository ProgramadorService
     */
    public ProgramadorService(RepoProgramador repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Programador a ProgramadorDTO
     * @return Optional<List<ProgramadorDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<ProgramadorDTO>> getAllProgramadores() throws SQLException {
        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Programador a ProgramadorDTO a partir de una ID
     * @param id de Programador
     * @return ProgramadorDTO
     * @throws SQLException Exception
     */
    public ProgramadorDTO getProgramadorById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Programador de save a ProgramadorDTO
     * @param programadorDTO ProgramadorDTO
     * @return ProgramadorDTO
     * @throws SQLException Exception
     */
    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Optional<Programador> res = this.save(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Programador a ProgramadorDTO
     * @param programadorDTO ProgramadorDTO
     * @return ProgramadorDTO
     * @throws SQLException Exception
     */
    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) throws SQLException {

        Optional<Programador> res = this.update(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res.get());

    }

    /**
     * Mapea el delete de Programador a ProgramadorDTO
     * @param programadorDTO ProgramadorDTO
     * @return ProgramadorDTO
     * @throws SQLException Exception
     */
    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Optional<Programador> res = this.delete(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res.get());
    }

}