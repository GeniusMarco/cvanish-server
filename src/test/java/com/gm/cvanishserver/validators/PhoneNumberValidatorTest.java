package com.gm.cvanishserver.validators;

import com.gm.cvanishserver.dto.PhoneNumberValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneNumberValidatorTest {
    private final PhoneNumberValidator validator = new PhoneNumberValidator();

    @Mock
    ConstraintValidatorContext context;

    @Test
    void shouldInvalidateWhenEmptyPassed() {
        assertFalse(validator.isValid("", context));
    }

    @Test
    void shouldInvalidateWhenTooLongWithoutCountryCodePassed() {
        assertFalse(validator.isValid("12345678901", context));
    }

    @Test
    void shouldInvalidateWhenTooLongWithCountryCodePassed() {
        assertFalse(validator.isValid("+1 12345678901", context));
    }

    @Test
    void shouldInvalidateWhenTooShortWithoutCountryCodePassed() {
        assertFalse(validator.isValid("12345", context));
    }

    @Test
    void shouldInvalidateWhenTooShortWithCountryCodePassed() {
        assertFalse(validator.isValid("+1 12345", context));
    }

    @Test
    void shouldInvalidateWhenFourDigitCountryCodePassed() {
        assertFalse(validator.isValid("+1234-123-456-7890", context));
    }

    @Test
    void shouldInvalidateWhenIncorrectCountryCodePassed() {
        assertFalse(validator.isValid("+ 1234567890", context));
    }

    @Test
    void shouldValidate() {
        assertTrue(validator.isValid("+1 1234567890", context));
        assertTrue(validator.isValid("+123 1234567890", context));
        assertTrue(validator.isValid("+48 123456789", context));
        assertTrue(validator.isValid("123456", context));
        assertTrue(validator.isValid("1234567890", context));
        assertTrue(validator.isValid("+1-111-111-1111", context));
        assertTrue(validator.isValid("+48 291 233 932", context));
    }
}
