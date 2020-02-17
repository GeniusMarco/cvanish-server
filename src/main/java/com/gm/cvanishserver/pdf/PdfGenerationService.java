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
        templateString = templateString.replaceAll("\\$experiences", buildExperiencesString(incomingDTO.getExperiences()));
        templateString = templateString.replaceAll("\\$skills", incomingDTO.getSkills().replaceAll("\n", "<br />"));
        return templateString;
    }

    private String buildExperiencesString(List<Map<String, String>> experiences) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> experience : experiences) {
            sb.append(String.format(
                            "<div class=\"experience\">\n" +
                            "           <h2>%s</h2>\n" +
                            "           <span class=\"subtitle\">%s, %s, %s, (%s - %s)</span>\n" +
                            "       </div>",
                    experience.get("role"),
                    experience.get("company"),
                    experience.get("city"),
                    experience.get("country"),
                    experience.get("sinceDate"),
                    (StringUtils.isEmpty(experience.get("toDate")) ? "Present" : experience.get("toDate"))));
        }
        return sb.toString();
    }

}
