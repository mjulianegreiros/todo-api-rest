package com.example.todo;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRegisterUserSuccessfully() throws Exception{
        mockMvc.perform(post("/api/register").
        contentType(MediaType.APPLICATION_JSON).
        content("{\"name\":\"JoãoSilva\",\"email\":\"joao@test.com\",\"password\":\"senha123\"}")).
        andDo(print()).
        andExpect(status().isCreated());
    }
    
}
