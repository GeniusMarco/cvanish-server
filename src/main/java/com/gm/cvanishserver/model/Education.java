package com.gm.cvanishserver.model;

import com.gm.cvanishserver.utils.DateUtils;
import lombok.Value;

@Value
public class Education implements Renderable {
    String fieldOfStudy;
    String level;
    String sinceDate;
    String toDate;
    String university;
    String city;
    String country;

    @Override
    public String toHtml() {
        return String.format("<div class=\"education\"><h2>%s, %s %s</h2><span class=\"subtitle\">%s, %s, %s</span></div>",
                this.getFieldOfStudy(),
                this.getLevel(),
                DateUtils.createDateString(this.getSinceDate(), this.getToDate()),
                this.getUniversity(),
                this.getCity(),
                this.getCountry());
    }
}
