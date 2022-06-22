package springbootpart1.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addUserTest() throws Exception {
        mockMvc.perform(post("/user/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content("Sadio Mane")).andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void getUserTest() throws Exception {
        mockMvc.perform(get("/user/{id}",1)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/user/{id}",1)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
