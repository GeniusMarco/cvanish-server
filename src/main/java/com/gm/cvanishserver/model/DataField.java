package com.gm.cvanishserver.model;

import java.util.Arrays;

public enum DataField {
    FIRST_NAME ("firstName", "First name:"),
    LAST_NAME ("lastName", "Last name:"),
    EXPERIENCE ("experiences", "Experience:");

    private final String key;
    private final String header;

    DataField(String key, String header) {
        this.key = key;
        this.header = header;
    }

    public String getKey() {
        return key;
    }

    public String getHeader() {
        return header;
    }

    public DataField getByKey(String key) {
        return Arrays.stream(DataField.values())
                .filter(v -> key.equals(v.getKey()))
                .findFirst()
                .orElseThrow();
    }
}
