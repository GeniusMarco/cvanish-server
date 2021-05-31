package com.gm.cvanishserver.model;

public interface Multiline {
    default String replaceNewLinesWithHtmlBreaks(String text) {
        return text.replaceAll("\n", "<br />");
    }
}
