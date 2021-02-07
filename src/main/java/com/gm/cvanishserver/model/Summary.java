package com.gm.cvanishserver.model;

import lombok.Value;
import org.springframework.util.StringUtils;

import static com.gm.cvanishserver.utils.HtmlUtils.replaceNewLinesWithHtmlBreaks;

@Value
public class Summary implements Renderable {
    String text;

    @Override
    public String toHtml() {
        return StringUtils.isEmpty(this.getText()) ? "" :
                String.format("<div id=\"summary\"><p>%s</p></div><div class=\"clear\"></div>", replaceNewLinesWithHtmlBreaks(this.getText()));
    }
}
