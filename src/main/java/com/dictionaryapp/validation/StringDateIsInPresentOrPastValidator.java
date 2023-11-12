package com.dictionaryapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.time.LocalDate;

public class StringDateIsInPresentOrPastValidator implements ConstraintValidator<StringDateIsInPresentOrPast, String> {

    @Override
    public void initialize(StringDateIsInPresentOrPast constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && !s.isBlank()) {
            LocalDate date = LocalDate.parse(s);
            if(date.isEqual(LocalDate.now())){
                return true;
            }
                return date.isBefore(LocalDate.now());
        }
        return false;
    }
}
