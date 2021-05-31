package com.gm.cvanishserver.model;

import lombok.Value;
import org.springframework.util.StringUtils;

@Value
public class Skills implements Renderable, Multiline {
    String text;

    @Override
    public String toHtml() {
        return StringUtils.isEmpty(this.getText()) ? "" : String.format("<dt>Skills</dt><dd>%s</dd>", replaceNewLinesWithHtmlBreaks(this.getText()));
    }
}
