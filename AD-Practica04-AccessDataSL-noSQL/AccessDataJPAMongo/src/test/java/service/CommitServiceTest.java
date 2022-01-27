package service;

import dao.Commit;
import org.junit.jupiter.api.*;
import repository.RepoCommit;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Test CommitService")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommitServiceTest {

    private CommitService service;
    private RepoCommit repository;
    private List<Commit> commits;

    @BeforeAll
    public void init(){
        repository=mock(RepoCommit.class);
        commits = List.of(new Commit(1L, "commit1", "probando", Timestamp.valueOf(LocalDateTime.now())),
                new Commit(2L, "commit2", "probando", Timestamp.valueOf(LocalDateTime.now())),
                new Commit(3L, "commit3", "probando", Timestamp.valueOf(LocalDateTime.now())));
        service=new CommitService(repository);
    }
    @Test
    @Order(1)
    void getAll() throws SQLException {
        when(this.repository.getAll()).thenReturn(Optional.of(commits));
        assertEquals(Optional.of(commits),service.getAllCommits());
    }
}
