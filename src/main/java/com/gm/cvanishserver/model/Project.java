package com.gm.cvanishserver.model;

import com.gm.cvanishserver.utils.DateUtils;
import lombok.Value;

import java.util.List;

@Value
public class Project implements Renderable {
    String title;
    String sinceYear;
    String toYear;
    List<ProjectLink> links;
    String description;

    @Override
    public String toHtml() {
        return String.format("<div class=\"project\"><h2>%s %s</h2>%s<div class=\"justified\">%s</div></div>",
                this.getTitle(),
                DateUtils.createDateString(this.getSinceYear(), this.getToYear()),
                buildProjectLinksString(this.getLinks()),
                this.getDescription());
    }

    private String buildProjectLinksString(List<ProjectLink> links) {
        StringBuilder sb = new StringBuilder();
        for (ProjectLink link : links) {
            sb.append(link.toHtml());
        }
        return String.format("<div style=\"margin-bottom: 10px\">%s</div>", sb.toString());
    }
}
