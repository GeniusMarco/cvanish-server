package com.gm.cvanishserver.model;

import lombok.Value;

import java.util.List;

@Value
public class Project implements Renderable, TimeBound {
    String title;
    String sinceYear;
    String toYear;
    List<ProjectLink> links;
    String description;

    @Override
    public String toHtml() {
        return String.format("<div class=\"project\"><h2>%s %s</h2>%s<div class=\"justified\">%s</div></div>",
                this.getTitle(),
                createDateString(this.getSinceYear(), this.getToYear()),
                buildProjectLinksString(this.getLinks()),
                this.getDescription());
    }

    private String buildProjectLinksString(List<ProjectLink> links) {
        StringBuilder sb = new StringBuilder();
        links.forEach(l -> sb.append(l.toHtml()));
        return String.format("<div style=\"margin-bottom: 10px\">%s</div>", sb.toString());
    }
}
