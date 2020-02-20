package com.gm.cvanishserver.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsTest {
    @Test
    void getting_nonempty_since_and_to_should_return_correct_string() {
        String expected = "(01-2001&nbsp;—&nbsp;12-2020)";
        String actual = DateUtils.createDateString("01-2001", "12-2020");
        assertEquals(expected, actual);
    }

    @Test
    void getting_empty_to_should_return_correct_string() {
        String expected = "(02-2002&nbsp;—&nbsp;Present)";
        String actual = DateUtils.createDateString("02-2002", "");
        assertEquals(expected, actual);
    }

    @Test
    void getting_null_to_should_return_correct_string() {
        String expected = "(02-2002&nbsp;—&nbsp;Present)";
        String actual = DateUtils.createDateString("02-2002", null);
        assertEquals(expected, actual);
    }

    @Test
    void getting_equal_since_and_to_should_return_correct_string() {
        String expected = "(2020)";
        String actual = DateUtils.createDateString("2020", "2020");
        assertEquals(expected, actual);
    }
}