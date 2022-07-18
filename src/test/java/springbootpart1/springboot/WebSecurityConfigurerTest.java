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
    public void userNameAndPasswordShouldNotWorkForInValidURL() throws Exception {
        ResponseEntity<String> response = template.withBasicAuth("user", "password")
                .getForEntity("/someurl", String.class);
                assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void userNameAndPasswordShouldNotWorkUnathorizedUser(){
        ResponseEntity<String> response = template.withBasicAuth("user","wrongpassword")
                .getForEntity("/user/1",String.class);
                assertEquals(HttpStatus.UNAUTHORIZED,response.getStatusCode());
    }

    @Test
    public void userNameAndPasswordShouldWorkForValidURL(){
        ResponseEntity<String> response = template.withBasicAuth("user","password")
                .getForEntity("/user/1",String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

}
