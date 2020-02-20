package com.gm.cvanishserver.model;

import com.gm.cvanishserver.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Education implements DataField {
    private String fieldOfStudy;
    private String level;
    private String sinceDate;
    private String toDate;
    private String university;
    private String city;
    private String country;

    @Override
    public String getHtml() {
        return String.format("<div class=\"education\"><h2>%s, %s %s</h2><span class=\"subtitle\">%s, %s, %s</span></div>",
                this.getFieldOfStudy(),
                this.getLevel(),
                DateUtils.createDateString(this.getSinceDate(), this.getToDate()),
                this.getUniversity(),
                this.getCity(),
                this.getCountry());
    }
}
