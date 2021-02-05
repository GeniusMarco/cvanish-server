package com.gm.cvanishserver.model;

import lombok.Value;

@Value
public class Link implements Renderable {
    String url;

    @Override
    public String toHtml() {
        return String.format("<div class=\"links\"><span class=\"link\"><a href=\"%s\">%s</a></span></div>", this.getUrl(), this.getUrl());
    }
}
