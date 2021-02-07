package com.gm.cvanishserver.model;

import lombok.Value;
import org.springframework.util.StringUtils;

import static com.gm.cvanishserver.utils.HtmlUtils.replaceNewLinesWithHtmlBreaks;

@Value
public class Skills implements Renderable {
    String text;

    @Override
    public String toHtml() {
        return StringUtils.isEmpty(this.getText()) ? "" : String.format("<dt>Skills</dt><dd>%s</dd>", replaceNewLinesWithHtmlBreaks(this.getText()));
    }
}
