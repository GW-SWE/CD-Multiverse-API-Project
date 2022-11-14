package swe.gw.apiproject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    public void shouldCreateNewUser() throws Exception{
        String user = "{  \n" +
                "    \"id\": \"2\",  \n" +
                "    \"name\":\"Steve\",\n" +
                "    \"age\":\"32\",\n" +
                "    \"email\": \"steve@gmail.com\"  \n" +
                "}   ";
            mvc.perform(post("/user").contentType("application/json").content(user)).andExpect(status().isOk());
            mvc.perform(get("/user/2")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Steve"));
            mvc.perform(get("/user/2")).andExpect(status().isOk()).andExpect(jsonPath("$.email").value("steve@gmail.com"));
        }

}
