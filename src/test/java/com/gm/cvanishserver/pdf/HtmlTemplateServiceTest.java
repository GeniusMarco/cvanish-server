package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.gm.cvanishserver.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HtmlTemplateServiceTest {
    @Autowired
    HtmlTemplateService htmlTemplateService;

    @Test
    void getting_basic_data_should_return_correctly_filled_template() throws IOException {
        IncomingDTO incomingDTO = IncomingDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("123456789")
                .email("email@address.com")
                .summary(new Summary(""))
                .skills(new Skills(""))
                .build();
        String filledTemplate = htmlTemplateService.fillTemplate(incomingDTO);
        assertTrue(filledTemplate.contains(incomingDTO.getFirstName() + " " + incomingDTO.getLastName()));
        assertTrue(filledTemplate.contains("Phone number:"));
        assertTrue(filledTemplate.contains(incomingDTO.getPhone()));
        assertTrue(filledTemplate.contains("Email address:"));
        assertTrue(filledTemplate.contains(incomingDTO.getEmail()));

        assertFalse(filledTemplate.contains("Experience"));
        assertFalse(filledTemplate.contains("Projects"));
        assertFalse(filledTemplate.contains("Education"));
        assertFalse(filledTemplate.contains("Skills"));
        assertFalse(filledTemplate.contains("Links"));
    }

    @Test
    void getting_complex_data_should_return_correctly_filled_template() throws IOException {
        IncomingDTO incomingDTO = IncomingDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("123456789")
                .email("email@address.com")
                .summary(new Summary("Summary text"))
                .experiences(List.of(new Experience("Developer", "Company", "New York", "USA", "2020", "")))
                .projects(List.of(new Project("Project title", "2019", "2020", List.of(new ProjectLink("0", "Link name")), "Project description")))
                .educations(List.of(new Education("Computer Science", "BSc", "01-2000", "12-2002", "MIT", "Cambridge", "USA")))
                .skills(new Skills("Java, Spring Boot"))
                .links(List.of(new Link("www.google.com")))
                .build();
        String filledTemplate = htmlTemplateService.fillTemplate(incomingDTO);
        assertTrue(filledTemplate.contains(incomingDTO.getFirstName() + " " + incomingDTO.getLastName()));
        assertTrue(filledTemplate.contains("Phone number:"));
        assertTrue(filledTemplate.contains(incomingDTO.getPhone()));
        assertTrue(filledTemplate.contains("Email address:"));
        assertTrue(filledTemplate.contains(incomingDTO.getEmail()));
        assertTrue(filledTemplate.contains("Experience"));
        assertTrue(filledTemplate.contains("Developer"));
        assertTrue(filledTemplate.contains("Company"));
        assertTrue(filledTemplate.contains("Projects"));
        assertTrue(filledTemplate.contains("Project title"));
        assertTrue(filledTemplate.contains("Project description"));
        assertTrue(filledTemplate.contains("Education"));
        assertTrue(filledTemplate.contains("Computer Science"));
        assertTrue(filledTemplate.contains("MIT"));
        assertTrue(filledTemplate.contains("Skills"));
        assertTrue(filledTemplate.contains("Java, Spring Boot"));
        assertTrue(filledTemplate.contains("Links"));
        assertTrue(filledTemplate.contains("www.google.com"));
    }
}