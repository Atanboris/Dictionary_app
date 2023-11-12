package com.dictionaryapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringDateIsInPresentOrPastValidator.class})
public @interface StringDateIsInPresentOrPast {
    String message() default "Date is not in present or past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

