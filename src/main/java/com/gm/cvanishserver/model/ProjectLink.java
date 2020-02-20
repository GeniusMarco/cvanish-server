package com.gm.cvanishserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
public class ProjectLink extends Link implements DataField {
    private String id;
    private String name;

    @Override
    public String getHtml() {
        return StringUtils.isEmpty(this.getName()) ? String.format("<div><span class=\"link\">%s</span></div>",this.getUrl()) :
                String.format("<div><span class=\"subtitle\">%s:</span> <span class=\"link\">%s</span></div>", this.getName(), getUrl());
    }
}
