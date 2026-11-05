package org.hyperskill.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTestIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getPerson_returnsPerson() throws Exception {
        mockMvc.perform(get("/persons/Alice"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("{\"id\": 1,\"name\": \"Alice\"}")
                );
    }

    @Test
    void getPerson_returns404() throws Exception {
        mockMvc.perform(get("/persons/Cecile"))
                .andExpect(status().isNotFound());
    }

}
