package service;

import dto.DepartamentoDTO;
import mapper.DepartamentoMapper;
import dao.Departamento;
import repository.RepoDepartamento;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DepartamentoService extends BaseService<Departamento, Long, RepoDepartamento> {

    DepartamentoMapper mapper = new DepartamentoMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public DepartamentoService(RepoDepartamento repository) {
        super(repository);
    }
    /**
     * Mapea todos los departamentos a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     **/
    public Optional<List<DepartamentoDTO>> getAllDepartamentos() throws SQLException {

        return mapper.toDTO(this.getAll());
    }
    /**
     * Mapea un departamento por id a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO getDepartamentoById(Long id) throws SQLException {

            return mapper.toDTO(this.getById(id).get());
    }
    /**
     * Mapea el save de departamento a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO postDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
            Optional<Departamento> res = this.save(mapper.fromDTO(departamentoDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el update de departamento a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
            Optional<Departamento> res = this.update(mapper.fromDTO(departamentoDTO));
                return mapper.toDTO(res.get());
    }
    /**
     * Mapea el delete de departamento a DTO
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
            Optional<Departamento> res = this.delete(mapper.fromDTO(departamentoDTO));
                return mapper.toDTO(res.get());
    }

    //Operacion 1
    public void departamentoFullInfo(long id) throws SQLException {
        RepoDepartamento repo = new RepoDepartamento();
        //repo.departamentoInfo(id);
    }
}