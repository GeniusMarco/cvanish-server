package com.gm.cvanishserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
public class Summary implements DataField {
    private String text;

    @Override
    public String getHtml() {
        return StringUtils.isEmpty(this.getText()) ? "" : String.format("<div id=\"summary\"><p>%s</p></div><div class=\"clear\"></div>", this.getText());
    }
}
