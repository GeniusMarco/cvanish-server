package com.gm.cvanishserver.model;

import lombok.Value;
import org.springframework.util.StringUtils;

@Value
public class Summary implements Renderable {
    String text;

    @Override
    public String toHtml() {
        return StringUtils.isEmpty(this.getText()) ? "" : String.format("<div id=\"summary\"><p>%s</p></div><div class=\"clear\"></div>", this.getText());
    }
}
