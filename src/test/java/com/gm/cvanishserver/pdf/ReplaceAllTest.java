package com.gm.cvanishserver.pdf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceAllTest {
    private final HtmlTemplateService service = new HtmlTemplateService();

    @Test
    void shouldReturnEmptyStringWhenBuilderIsEmpty() {
        StringBuilder builder = new StringBuilder();
        service.replaceAll(builder, "${placeholder}", "replacement");
        assertEquals(builder.toString(), "");
    }

    @Test
    void shouldReturnEmptyStringWhenReplacementEmpty() {
        StringBuilder builder = new StringBuilder("${placeholder}");
        service.replaceAll(builder, "${placeholder}", "");
        assertEquals(builder.toString(), "");
    }

    @Test
    void shouldReplaceWhenOnePlaceholderExists() {
        StringBuilder builder = new StringBuilder("Lorem ipsum ${placeholder} lorem ipsum");
        service.replaceAll(builder, "${placeholder}", "replacement");
        assertEquals(builder.toString(), "Lorem ipsum replacement lorem ipsum");
    }

    @Test
    void shouldReplaceWhenTwoPlaceholderExist() {
        StringBuilder builder = new StringBuilder("Lorem ipsum ${placeholder} lorem ipsum ${prank} ${placeholder} lorem ipsum");
        service.replaceAll(builder, "${placeholder}", "replacement");
        assertEquals(builder.toString(), "Lorem ipsum replacement lorem ipsum ${prank} replacement lorem ipsum");
    }

    @Test
    void shouldNotReplaceWhenNoPlaceholdersExist() {
        StringBuilder builder = new StringBuilder("Lorem ipsum ${prank} lorem ipsum");
        service.replaceAll(builder, "${placeholder}", "replacement");
        assertEquals(builder.toString(), "Lorem ipsum ${prank} lorem ipsum");
    }
}
