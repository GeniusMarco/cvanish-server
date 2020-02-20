package com.gm.cvanishserver.utils;

import org.springframework.util.StringUtils;

public final class DateUtils {
    public static String createDateString(String since, String to) {
        if (StringUtils.isEmpty(to)) {
            return ("(" + since + "&nbsp;—&nbsp;Present)");
        }
        if (to.equals(since)) {
            return ("(" + since + ")");
        }
        return ("(" + since + "&nbsp;—&nbsp;" + to + ")");
    }
}
