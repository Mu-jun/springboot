package mjspring.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {
    @Test
    void helloApi() {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> resp = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // 응답검증 3가지
        // status code 200
        Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        Assertions.assertThat(resp.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        Assertions.assertThat(resp.getBody()).isEqualTo("Hello Spring");
    }

    @Test
    void failshelloApi() {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> resp = rest.getForEntity("http://localhost:8080/hello?name=", String.class);

        Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
