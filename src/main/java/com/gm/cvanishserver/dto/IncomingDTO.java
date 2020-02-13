package com.gm.cvanishserver.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class IncomingDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String summary;
    private List<Map<String, String>> experiences;
    private List<Map<String, String>> educations;
    private String skills;
    private List<String> links;
}
