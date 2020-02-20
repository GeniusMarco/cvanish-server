package com.gm.cvanishserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link implements DataField {
    private String url;

    @Override
    public String getHtml() {
        return String.format("<div class=\"links\"><span class=\"link\"><a href=\"%s\">%s</a></span></div>", this.getUrl(), this.getUrl());
    }
}
