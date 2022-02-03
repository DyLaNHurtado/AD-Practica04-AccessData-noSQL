package service;

import dao.Issue;
import dto.IssueDTO;
import mapper.DepartamentoMapper;
import mapper.IssueMapper;
import repository.RepoDepartamento;
import repository.RepoIssue;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio del Issue
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class IssueService extends BaseService<Issue, Long, RepoIssue> {

    IssueMapper mapper = new IssueMapper();

    public IssueService(RepoIssue repository) {
        super(repository);
    }

    /**
     * Mapea todos los issues a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public Optional<List<IssueDTO>> getAllIssues() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un issue por id a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public IssueDTO getIssueById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el issue de departamento a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public IssueDTO postIssue(IssueDTO issueDTO) throws SQLException {
        Optional<Issue> res = this.save(mapper.fromDTO(issueDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de issue a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public IssueDTO updateIssue(IssueDTO issueDTO) throws SQLException {
        Optional<Issue> res = this.update(mapper.fromDTO(issueDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de issue a DTO
     *
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public IssueDTO deleteIssue(IssueDTO issueDTO) throws SQLException {
        Optional<Issue> res = this.delete(mapper.fromDTO(issueDTO));
        return mapper.toDTO(res.get());
    }

}
