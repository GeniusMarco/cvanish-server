package com.gm.cvanishserver.model;

import lombok.Value;

@Value
public class Education implements Renderable, TimeBound {
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
                createDateString(this.getSinceDate(), this.getToDate()),
                this.getUniversity(),
                this.getCity(),
                this.getCountry());
    }
}
