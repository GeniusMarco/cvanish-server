package com.gm.cvanishserver.model;

import lombok.Value;
import org.springframework.util.StringUtils;

@Value
public class ProjectLink implements Renderable {
    String url;
    String id;
    String name;

    @Override
    public String toHtml() {
        return StringUtils.isEmpty(this.getName()) ? String.format("<div><span class=\"link\"><a href=\"%s\">%s</a></span></div>",this.getUrl(), this.getUrl()) :
                String.format("<div><span class=\"subtitle\">%s:</span> <span class=\"link\"><a href=\"%s\">%s</a></span></div>", this.getName(), this.getUrl(), this.getUrl());
    }
}
