package com.gm.cvanishserver.dto;

import com.gm.cvanishserver.model.*;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@Builder
@ToString(of = {"firstName", "lastName", "phone", "email"})
public class FormDTO {
    String firstName;
    String lastName;
    String phone;
    String email;
    Summary summary;
    List<Experience> experiences;
    List<Project> projects;
    List<Education> educations;
    Skills skills;
    List<Link> links;
}
