package repositorio;

import dao.Commit;
import manager.HibernateController;
import org.junit.jupiter.api.*;
import repository.RepoCommit;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test RepoCommit")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepoCommitTest {

    private HibernateController controller;
    private RepoCommit repoCommit;
    private List<Commit> commits;

    @BeforeAll
    private void init() {
        commits = List.of(new Commit(1L, "commit1", "probando", Timestamp.valueOf(LocalDateTime.now())),
                new Commit(2L, "commit2", "probando", Timestamp.valueOf(LocalDateTime.now())),
                new Commit(3L, "commit3", "probando", Timestamp.valueOf(LocalDateTime.now())));
        controller = HibernateController.getInstance();
        repoCommit = new RepoCommit();
    }

    @Test
    @Order(1)
    void save() {

    }

    @Test
    @Order(2)
    void getAll() throws SQLException {
        assertAll(() -> assertEquals(repoCommit.getAll(), Optional.of(commits)),
                () -> assertNotNull(repoCommit.getAll()));
    }
}
