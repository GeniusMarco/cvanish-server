package com.gm.cvanishserver.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches("(\\+\\d{1,3})?(\\s|-)?\\d{3}(\\s{1}|-)?(\\s|-)?\\d{3}(\\s|-)?\\d{0,4}", value);
    }
}
