package com.gm.cvanishserver.dto;

import com.gm.cvanishserver.model.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString(exclude = {"summary", "skills"})
public class IncomingDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Summary summary;
    private List<Experience> experiences;
    private List<Project> projects;
    private List<Education> educations;
    private Skills skills;
    private List<Link> links;
}
