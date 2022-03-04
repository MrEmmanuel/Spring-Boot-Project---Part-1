package springbootpart1.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebSecurityConfigurerTest {

    @Autowired
    private TestRestTemplate template;


    @Test
    public void securityTest() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("spring", "secret")
                .getForEntity("/user", String.class);
                assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }
}
