package com.gm.cvanishserver.model;

import org.springframework.util.StringUtils;

public interface TimeBound {
    default String createDateString(String since, String to) {
        String nonBreakingSpace = "&nbsp;";
        if (StringUtils.isEmpty(to)) {
            return ("(" + since + nonBreakingSpace + "—" +  nonBreakingSpace + "Present)");
        }
        if (to.equals(since)) {
            return ("(" + since + ")");
        }
        return ("(" + since + nonBreakingSpace + "—" + nonBreakingSpace + to + ")");
    }
}
