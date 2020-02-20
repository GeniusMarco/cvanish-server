package com.gm.cvanishserver.model;

import com.gm.cvanishserver.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Experience implements DataField {
    private String role;
    private String company;
    private String city;
    private String country;
    private String sinceDate;
    private String toDate;

    @Override
    public String getHtml() {
        return String.format("<div class=\"experience\"><h2>%s %s</h2><span class=\"subtitle\">%s, %s, %s</span></div>",
                this.getRole(),
                DateUtils.createDateString(this.getSinceDate(), this.getToDate()),
                this.getCompany(),
                this.getCity(),
                this.getCountry());
    }
}
