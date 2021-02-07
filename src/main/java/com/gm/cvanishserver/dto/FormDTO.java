package com.gm.cvanishserver.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gm.cvanishserver.model.*;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

import static java.util.Collections.emptyList;

@Value
@Builder
@ToString(of = {"firstName", "lastName", "phone", "email"})
public class FormDTO {
    @NotEmpty
    String firstName;
    @NotEmpty
    String lastName;
    @NotEmpty
    @PhoneNumber
    String phone;
    @NotEmpty
    @Email
    String email;
    @Builder.Default
    @JsonSerialize(using = SummarySerializer.class)
    Summary summary = new Summary("");
    @Builder.Default
    List<Experience> experiences = emptyList();
    @Builder.Default
    List<Project> projects = emptyList();
    @Builder.Default
    List<Education> educations = emptyList();
    @Builder.Default
    @JsonSerialize(using = SkillsSerializer.class)
    Skills skills = new Skills("");
    @Builder.Default
    List<Link> links = emptyList();
}
