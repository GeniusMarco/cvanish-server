package com.gm.cvanishserver.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gm.cvanishserver.model.Summary;

import java.io.IOException;

public class SummarySerializer extends JsonSerializer<Summary> {
    @Override
    public void serialize(Summary value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getText());
    }
}
