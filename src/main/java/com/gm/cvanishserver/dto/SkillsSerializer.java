package com.gm.cvanishserver.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gm.cvanishserver.model.Skills;

import java.io.IOException;

public class SkillsSerializer extends JsonSerializer<Skills> {
    @Override
    public void serialize(Skills value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getText());
    }
}
