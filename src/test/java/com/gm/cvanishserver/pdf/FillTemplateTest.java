package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.FormDTO;
import com.gm.cvanishserver.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.gm.cvanishserver.pdf.AssertionConstants.EXPECTED_ALL_FIELDS;
import static com.gm.cvanishserver.pdf.AssertionConstants.EXPECTED_REQUIRED_FIELDS_ONLY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FillTemplateTest {
    final HtmlTemplateService htmlTemplateService = new HtmlTemplateService();

    @Test
    void shouldFillTemplateWithRequiredFieldsOnlyCorrectly() throws IOException {
        FormDTO formDTO = FormDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("123456789")
                .email("email@address.com")
                .build();
        String filledTemplate = htmlTemplateService.fillTemplate(formDTO);
        assertEquals(EXPECTED_REQUIRED_FIELDS_ONLY, filledTemplate);
    }

    @Test
    void shouldFillTemplateWithAllFieldsCorrectly() throws IOException {
        FormDTO formDTO = FormDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("123456789")
                .email("email@address.com")
                .summary(new Summary("Summary text"))
                .experiences(List.of(new Experience("Developer", "Company", "New York", "USA", "2020", "")))
                .projects(List.of(new Project("Project title", "2019", "2020", List.of(new ProjectLink("google.com", "0", "Link name")), "Project description")))
                .educations(List.of(new Education("Computer Science", "BSc", "01-2000", "12-2002", "MIT", "Cambridge", "USA")))
                .skills(new Skills("Java, Spring Boot"))
                .links(List.of(new Link("www.google.com")))
                .build();
        String filledTemplate = htmlTemplateService.fillTemplate(formDTO);
        assertEquals(EXPECTED_ALL_FIELDS, filledTemplate);
    }
}
