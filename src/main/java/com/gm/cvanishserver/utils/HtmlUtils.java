package com.gm.cvanishserver.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HtmlUtils {
    public String replaceNewLinesWithHtmlBreaks(String text) {
        return text.replaceAll("\n", "<br />");
    }
}
