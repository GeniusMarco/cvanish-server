package com.gm.cvanishserver.utils;

import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

@UtilityClass
public class DateUtils {
    private static final String NONBREAKING_SPACE = "&nbsp;";

    public String createDateString(String since, String to) {
        if (StringUtils.isEmpty(to)) {
            return ("(" + since + NONBREAKING_SPACE + "—" +  NONBREAKING_SPACE + "Present)");
        }
        if (to.equals(since)) {
            return ("(" + since + ")");
        }
        return ("(" + since + NONBREAKING_SPACE + "—" + NONBREAKING_SPACE + to + ")");
    }
}
