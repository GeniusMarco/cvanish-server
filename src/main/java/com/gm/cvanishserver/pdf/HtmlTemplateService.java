package com.gm.cvanishserver.pdf;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class HtmlTemplateService {

    String buildExperiencesString(List<Map<String, String>> experiences) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> experience : experiences) {
            sb.append(String.format(
                    "<div class=\"experience\"><h2>%s %s</h2><span class=\"subtitle\">%s, %s, %s</span></div>",
                    experience.get("role"),
                    createDateString(experience.get("sinceDate"), experience.get("toDate")),
                    experience.get("company"),
                    experience.get("city"),
                    experience.get("country")));
        }
        return sb.toString();
    }

    String buildProjectLinksString(List<Map<String, String>> links) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> link : links) {
            sb.append(createProjectLinkString(link.get("name"), link.get("url")));
        }
        return "<div style=\"margin-bottom: 10px\">" + sb.toString() + "</div>";
    }

    String buildProjectsString(List<Map<String, Object>> projects) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> project : projects) {
            sb.append(String.format(
                    "<div class=\"project\"><h2>%s %s</h2>%s<div class=\"justified\">%s</div></div>",
                    project.get("title"),
                    createDateString((String) project.get("sinceYear"), (String) project.get("toYear")),
                    buildProjectLinksString((List<Map<String, String>>) project.get("links")),
                    replaceNewLinesWithHtmlBreaks((String) project.get("description"))));
        }
        return sb.toString();
    }

    String buildEducationsString(List<Map<String, String>> educations) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> education : educations) {
            sb.append(String.format(
                    "<div class=\"education\"><h2>%s, %s %s</h2><span class=\"subtitle\">%s, %s, %s</span></div>",
                    education.get("fieldOfStudy"),
                    education.get("level"),
                    createDateString(education.get("sinceDate"), education.get("toDate")),
                    education.get("university"),
                    education.get("city"),
                    education.get("country")));
        }
        return sb.toString();
    }

    String buildLinksString(List<String> links) {
        StringBuilder sb = new StringBuilder();
        for (String link : links) {
            sb.append("<div class=\"links\"><span class=\"link\">").append(link).append("</span></div>");
        }
        return sb.toString();
    }

    String replaceNewLinesWithHtmlBreaks(String text) {
        return text.replaceAll("\n", "<br />");
    }

    private String createDateString(String since, String to) {
        if (StringUtils.isEmpty(to)) {
            return ("(" + since + "&nbsp;—&nbsp;Present)");
        }
        if (to.equals(since)) {
            return ("(" + since + ")");
        }
        return ("(" + since + "&nbsp;—&nbsp;" + to + ")");
    }

    private String createProjectLinkString(String name, String url) {
        return StringUtils.isEmpty(name) ? "<div><span class=\"link\">" + url + "</span></div>" :
                String.format("<div><span class=\"subtitle\">%s:</span> <span class=\"link\">%s</span></div>",
                        name, url);
    }
}
