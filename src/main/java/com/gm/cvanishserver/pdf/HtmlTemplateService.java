package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.FormDTO;
import com.gm.cvanishserver.model.Renderable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class HtmlTemplateService {

    String fillTemplate(FormDTO formDTO) throws IOException {
        String templateString = Files.readString(ResourceUtils.getFile("classpath:template.html").toPath());
        templateString = templateString.replace("$firstName", formDTO.getFirstName());
        templateString = templateString.replace("$lastName", formDTO.getLastName());
        templateString = templateString.replace("$phone", formDTO.getPhone());
        templateString = templateString.replace("$email", formDTO.getEmail());
        templateString = templateString.replace("$summary", replaceNewLinesWithHtmlBreaks(formDTO.getSummary().toHtml()));
        templateString = templateString.replace("$experiences", aggregateHtmls(formDTO.getExperiences(), "Experience"));
        templateString = templateString.replace("$projects", aggregateHtmls(formDTO.getProjects(), "Projects"));
        templateString = templateString.replace("$educations", aggregateHtmls(formDTO.getEducations(), "Education"));
        templateString = templateString.replace("$skills", replaceNewLinesWithHtmlBreaks(formDTO.getSkills().toHtml()));
        templateString = templateString.replace("$links", aggregateHtmls(formDTO.getLinks(), "Links"));
        return templateString;
    }


    String aggregateHtmls(List<? extends Renderable> list, String header) {
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.format("<dt>%s</dt><dd>", header));
        list.forEach(df -> sb.append(df.toHtml()));
        return sb.append("</dd>").toString();
    }

    String replaceNewLinesWithHtmlBreaks(String text) {
        return text.replaceAll("\n", "<br />");
    }

}
