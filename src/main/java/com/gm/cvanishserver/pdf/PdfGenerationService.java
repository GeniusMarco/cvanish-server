package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PdfGenerationService {

    final HtmlTemplateService htmlTemplateService;

    public PdfGenerationService(HtmlTemplateService htmlTemplateService) {
        this.htmlTemplateService = htmlTemplateService;
    }

    public byte[] transformToPdf(IncomingDTO incomingDTO) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String templateString = Files.readString(Paths.get("src/main/resources/template.html"));
        HtmlConverter.convertToPdf(fillTemplate(templateString, incomingDTO), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String fillTemplate(String templateString, IncomingDTO incomingDTO) {
        templateString = templateString.replace("$firstName", incomingDTO.getFirstName());
        templateString = templateString.replace("$lastName", incomingDTO.getLastName());
        templateString = templateString.replace("$phone", incomingDTO.getPhone());
        templateString = templateString.replace("$email", incomingDTO.getEmail());
        templateString = templateString.replace("$summary", htmlTemplateService.replaceNewLinesWithHtmlBreaks(incomingDTO.getSummary()));
        templateString = templateString.replace("$experiences", htmlTemplateService.buildExperiencesString(incomingDTO.getExperiences()));
        templateString = templateString.replace("$projects", htmlTemplateService.buildProjectsString(incomingDTO.getProjects()));
        templateString = templateString.replace("$educations", htmlTemplateService.buildEducationsString(incomingDTO.getEducations()));
        templateString = templateString.replace("$skills", htmlTemplateService.replaceNewLinesWithHtmlBreaks(incomingDTO.getSkills()));
        templateString = templateString.replace("$links", htmlTemplateService.buildLinksString(incomingDTO.getLinks()));
        return templateString;
    }


}
