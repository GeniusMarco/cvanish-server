package com.gm.cvanishserver.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gm.cvanishserver.dto.FormDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnOk() throws Exception {
        FormDTO formDTO = FormDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("123456789")
                .email("email@address.com")
                .build();
        String json = objectMapper.writeValueAsString(formDTO);

        mockMvc.perform(post("/generate")
                .content(json)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_PDF_VALUE));
    }

    @Test
    void shouldReturnBadRequest() throws Exception {
        FormDTO formDTO = FormDTO.builder()
                .firstName("")
                .lastName("")
                .phoneNumber("")
                .email("")
                .build();
        String json = objectMapper.writeValueAsString(formDTO);

        mockMvc.perform(post("/generate")
                .content(json)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
