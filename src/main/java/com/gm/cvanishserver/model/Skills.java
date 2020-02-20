package com.gm.cvanishserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
public class Skills implements DataField {
    private String text;

    @Override
    public String getHtml() {
        return StringUtils.isEmpty(this.getText()) ? "" : String.format("<dt>Skills</dt><dd>%s</dd>", this.getText());
    }
}
