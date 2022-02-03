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

    /**
     * Constructor con inyección de dependencias
     * @param repository IssueService
     */
    public IssueService(RepoIssue repository) {
        super(repository);
    }

    /**
     * Mapea una lista de Issue a IssueDTO
     * @return Optional<List<IssueDTO>>
     * @throws SQLException Exception
     */
    public Optional<List<IssueDTO>> getAllIssues() throws SQLException {

        return mapper.toDTO(this.getAll());
    }

    /**
     * Mapea un Issue a IssueDTO a partir de una ID
     * @param id de Issue
     * @return IssueDTO
     * @throws SQLException Exception
     */
    public IssueDTO getIssueById(long id) throws SQLException {

        return mapper.toDTO(this.getById(id).get());
    }

    /**
     * Mapea el Issue de save a IssueDTO
     * @param issueDTO IssueDTO
     * @return IssueDTO
     * @throws SQLException Exception
     */
    public IssueDTO postIssue(IssueDTO issueDTO) throws SQLException {
        Optional<Issue> res = this.save(mapper.fromDTO(issueDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el update de Issue a IssueDTO
     * @param issueDTO IssueDTO
     * @return IssueDTO
     * @throws SQLException Exception
     */
    public IssueDTO updateIssue(IssueDTO issueDTO) throws SQLException {
        Optional<Issue> res = this.update(mapper.fromDTO(issueDTO));
        return mapper.toDTO(res.get());
    }

    /**
     * Mapea el delete de Issue a IssueDTO
     * @param issueDTO IssueDTO
     * @return IssueDTO
     * @throws SQLException Exception
     */
    public IssueDTO deleteIssue(IssueDTO issueDTO) throws SQLException {
        Optional<Issue> res = this.delete(mapper.fromDTO(issueDTO));
        return mapper.toDTO(res.get());
    }

}
