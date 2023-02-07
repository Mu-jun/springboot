package mjspring.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("mj")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("mj")).isEqualTo(0);

        helloRepository.increaseCount("mj");
        assertThat(helloRepository.countOf("mj")).isEqualTo(1);

        helloRepository.increaseCount("mj");
        assertThat(helloRepository.countOf("mj")).isEqualTo(2);
    }
}
