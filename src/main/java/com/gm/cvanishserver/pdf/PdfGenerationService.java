package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class PdfGenerationService {

    public byte[] transformToPdf(IncomingDTO incomingDTO) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String templateString = Files.readString(Paths.get("src/main/resources/template.html"));
        String pdfString = fillTemplate(templateString, incomingDTO);
        HtmlConverter.convertToPdf(pdfString, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String fillTemplate(String templateString, IncomingDTO incomingDTO) {
        templateString = templateString.replaceAll("\\$firstName", incomingDTO.getFirstName());
        templateString = templateString.replaceAll("\\$lastName", incomingDTO.getLastName());
        templateString = templateString.replaceAll("\\$phone", incomingDTO.getPhone());
        templateString = templateString.replaceAll("\\$email", incomingDTO.getEmail());
        templateString = templateString.replaceAll("\\$summary", incomingDTO.getSummary());
        templateString = templateString.replace("$experiences", buildExperiencesString(incomingDTO.getExperiences()));
        templateString = templateString.replace("$projects", buildProjectsString(incomingDTO.getProjects()));
        templateString = templateString.replace("$educations", buildEducationsString(incomingDTO.getEducations()));
        templateString = templateString.replaceAll("\\$skills", incomingDTO.getSkills().replaceAll("\n", "<br />"));
        return templateString;
    }

    private String buildExperiencesString(List<Map<String, String>> experiences) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> experience : experiences) {
            sb.append(String.format(
                            "<div class=\"experience\"><h2>%s</h2><span class=\"subtitle\">%s, %s, %s, (%s - %s)</span></div>",
                    experience.get("role"),
                    experience.get("company"),
                    experience.get("city"),
                    experience.get("country"),
                    experience.get("sinceDate"),
                    (StringUtils.isEmpty(experience.get("toDate")) ? "Present" : experience.get("toDate"))));
        }
        return sb.toString();
    }

    private String buildProjectLinksString(List<Map<String, String>> links) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> link : links) {
            sb.append(String.format(
                    "<div>%s: %s</div>",
                    link.get("name"),
                    link.get("url")));
        }
        return sb.toString();
    }

    private String buildProjectsString(List<Map<String, Object>> projects) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> project : projects) {
            sb.append(String.format(
                    "<div class=\"project\"><h2>%s (%s - %s)</h2>%s<span>%s</span></div>",
                    project.get("title"),
                    project.get("sinceYear"),
                    project.get("toYear"),
                    buildProjectLinksString((List<Map<String, String>>) project.get("links")),
                    project.get("description")));
        }
        return sb.toString();
    }

    private String buildEducationsString(List<Map<String, String>> educations) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> education : educations) {
            sb.append(String.format(
                    "<div class=\"education\"><h2>%s, %s</h2><span class=\"subtitle\">%s, %s, %s, (%s - %s)</span></div>",
                    education.get("fieldOfStudy"),
                    education.get("level"),
                    education.get("university"),
                    education.get("city"),
                    education.get("country"),
                    education.get("sinceDate"),
                    (StringUtils.isEmpty(education.get("toDate")) ? "Present" : education.get("toDate"))));
        }
        return sb.toString();
    }

}
