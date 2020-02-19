package com.gm.cvanishserver.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class ApiControllerIntegrationTest {
    public static final String ENDPOINT = "/api";
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void dummy() throws Exception {
        mockMvc.perform(get(ENDPOINT))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void receiving() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("firstName", "John");
        map.put("lastName", "Doe");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map);

        mockMvc.perform(post(ENDPOINT + "/data").contentType("application/json")
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}