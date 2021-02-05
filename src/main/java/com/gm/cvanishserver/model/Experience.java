package com.gm.cvanishserver.model;

import com.gm.cvanishserver.utils.DateUtils;
import lombok.Value;

@Value
public class Experience implements Renderable {
    String role;
    String company;
    String city;
    String country;
    String sinceDate;
    String toDate;

    @Override
    public String toHtml() {
        return String.format("<div class=\"experience\"><h2>%s %s</h2><span class=\"subtitle\">%s, %s, %s</span></div>",
                this.getRole(),
                DateUtils.createDateString(this.getSinceDate(), this.getToDate()),
                this.getCompany(),
                this.getCity(),
                this.getCountry());
    }
}
