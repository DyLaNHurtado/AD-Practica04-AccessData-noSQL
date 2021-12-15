package service;

import dao.Proyecto;
import dto.ProgramadorDTO;
import dto.ProyectoDTO;
import mapper.ProgramadorMapper;
import dao.Programador;
import mapper.ProyectoMapper;
import repository.RepoProgramador;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProgramadorService extends BaseService<Programador, String, RepoProgramador> {

    ProgramadorMapper mapper = new ProgramadorMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public ProgramadorService(RepoProgramador repository) {
        super(repository);
    }
    /**
     * Mapea todos los programadores a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<ProgramadorDTO>> getAllProgramadores() throws SQLException {
        return mapper.toDTO(this.getAll());
    }
    /**
     * Mapea un programador por id a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProgramadorDTO getProgramadorById(String id) throws SQLException {
            return mapper.toDTO(this.getById(id).get());
    }
    /**
     * Mapea el save de programador a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) throws SQLException {
            Optional<Programador> res = this.save(mapper.fromDTO(programadorDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el update de programador a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO) throws SQLException {

            Optional<Programador> res = this.update(mapper.fromDTO(programadorDTO));
                return mapper.toDTO(res.get());

    }
    /**
     * Mapea el delete de programador a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO) throws SQLException {
            Optional<Programador> res = this.delete(mapper.fromDTO(programadorDTO));
                return mapper.toDTO(res.get());
    }


    //Operacion 4
    public void getAllProgramadoresFullInfo() throws SQLException {
        if (this.getAll().isPresent()) {
            List<Programador> programadores = this.getAll().get();
            programadores.forEach(x -> System.out.println(x.toStringProductividad()));

        }
    }



}