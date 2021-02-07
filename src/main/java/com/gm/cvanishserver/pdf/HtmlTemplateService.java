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
        StringBuilder builder = new StringBuilder(Files.readString(ResourceUtils.getFile("classpath:template.html").toPath()));
        replaceAll(builder, "$firstName", formDTO.getFirstName());
        replaceAll(builder, "$lastName", formDTO.getLastName());
        replaceAll(builder, "$phone", formDTO.getPhoneNumber());
        replaceAll(builder, "$email", formDTO.getEmail());
        replaceAll(builder, "$summary", formDTO.getSummary().toHtml());
        replaceAll(builder, "$experiences", listToHtmlWithHeader(formDTO.getExperiences(), "Experience"));
        replaceAll(builder, "$projects", listToHtmlWithHeader(formDTO.getProjects(), "Projects"));
        replaceAll(builder, "$educations", listToHtmlWithHeader(formDTO.getEducations(), "Education"));
        replaceAll(builder, "$skills", formDTO.getSkills().toHtml());
        replaceAll(builder, "$links", listToHtmlWithHeader(formDTO.getLinks(), "Links"));
        return builder.toString();
    }

    void replaceAll(StringBuilder builder, String placeholder, String replacement) {
        int index = builder.indexOf(placeholder);
        while (index != -1) {
            builder.replace(index, index + placeholder.length(), replacement);
            index = builder.indexOf(placeholder, index + replacement.length());
        }
    }

    private <T extends Renderable> String listToHtmlWithHeader(List<T> renderables, String header) {
        if (CollectionUtils.isEmpty(renderables)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.format("<dt>%s</dt><dd>", header));
        renderables.forEach(r -> sb.append(r.toHtml()));
        return sb.append("</dd>").toString();
    }
}
