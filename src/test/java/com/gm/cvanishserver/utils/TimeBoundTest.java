package com.gm.cvanishserver.utils;

import com.gm.cvanishserver.model.TimeBound;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeBoundTest implements TimeBound {
    @Test
    void shouldCreateDateStringWhenBothDatesDifferent() {
        String expected = "(01-2001&nbsp;—&nbsp;12-2020)";
        String actual = createDateString("01-2001", "12-2020");
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateDateStringWhenToDateEmpty() {
        String expected = "(02-2002&nbsp;—&nbsp;Present)";
        String actual = createDateString("02-2002", "");
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateDateStringWhenToDateNull() {
        String expected = "(02-2002&nbsp;—&nbsp;Present)";
        String actual = createDateString("02-2002", null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateDateStringWhenBothDatesEqual() {
        String expected = "(2020)";
        String actual = createDateString("2020", "2020");
        assertEquals(expected, actual);
    }
}
