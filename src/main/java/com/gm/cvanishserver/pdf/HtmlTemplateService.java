package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.gm.cvanishserver.model.DataField;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class HtmlTemplateService {

    String fillTemplate(IncomingDTO incomingDTO) throws IOException {
        String templateString = Files.readString(ResourceUtils.getFile("classpath:template.html").toPath());
        templateString = templateString.replace("$firstName", incomingDTO.getFirstName());
        templateString = templateString.replace("$lastName", incomingDTO.getLastName());
        templateString = templateString.replace("$phone", incomingDTO.getPhone());
        templateString = templateString.replace("$email", incomingDTO.getEmail());
        templateString = templateString.replace("$summary", replaceNewLinesWithHtmlBreaks(incomingDTO.getSummary().getHtml()));
        templateString = templateString.replace("$experiences", aggregateHtmls(incomingDTO.getExperiences(), "Experience"));
        templateString = templateString.replace("$projects", aggregateHtmls(incomingDTO.getProjects(), "Projects"));
        templateString = templateString.replace("$educations", aggregateHtmls(incomingDTO.getEducations(), "Education"));
        templateString = templateString.replace("$skills", replaceNewLinesWithHtmlBreaks(incomingDTO.getSkills().getHtml()));
        templateString = templateString.replace("$links", aggregateHtmls(incomingDTO.getLinks(), "Links"));
        return templateString;
    }


    String aggregateHtmls(List<? extends DataField> list, String header) {
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.format("<dt>%s</dt><dd>", header));
        list.forEach(df -> sb.append(df.getHtml()));
        return sb.append("</dd>").toString();
    }

    String replaceNewLinesWithHtmlBreaks(String text) {
        return text.replaceAll("\n", "<br />");
    }

}
