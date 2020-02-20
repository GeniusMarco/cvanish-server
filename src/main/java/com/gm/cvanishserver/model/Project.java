package com.gm.cvanishserver.model;

import com.gm.cvanishserver.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Project implements DataField {
    private String title;
    private String sinceYear;
    private String toYear;
    private List<ProjectLink> links;
    private String description;

    @Override
    public String getHtml() {
        return String.format("<div class=\"project\"><h2>%s %s</h2>%s<div class=\"justified\">%s</div></div>",
                this.getTitle(),
                DateUtils.createDateString(this.getSinceYear(), this.getToYear()),
                buildProjectLinksString(this.getLinks()),
                this.getDescription());
    }

    private String buildProjectLinksString(List<ProjectLink> links) {
        StringBuilder sb = new StringBuilder();
        for (ProjectLink link : links) {
            sb.append(link.getHtml());
        }
        return String.format("<div style=\"margin-bottom: 10px\">%s</div>", sb.toString());
    }
}
