package mjspring.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1,10).forEach(count -> {
            helloService.sayHello("mj");
            assertThat(helloRepository.countOf("mj")).isEqualTo(count);
        });
    }
}
