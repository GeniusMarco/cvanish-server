package com.gm.cvanishserver.validators;

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
public class PhoneNumberMvcTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnOk() throws Exception {
        FormDTO formDTO = FormDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("123456789")
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
    void shouldReturnError() throws Exception {
        FormDTO formDTO = FormDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("1111111111111111")
                .email("email@address.com")
                .build();
        String json = objectMapper.writeValueAsString(formDTO);

        mockMvc.perform(post("/generate")
                .content(json)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
