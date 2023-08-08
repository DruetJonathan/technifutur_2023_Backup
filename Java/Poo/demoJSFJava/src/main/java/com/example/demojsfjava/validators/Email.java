package com.example.demojsfjava.validators;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Email {
    String message() default "Is not a valid email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
