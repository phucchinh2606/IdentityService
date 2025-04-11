package com.chinhdo.identity_service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD}) //su dung o dau?
@Retention(RetentionPolicy.RUNTIME)//xu ly luc nao?
@Constraint(validatedBy = {DobValidator.class})
public @interface DobConstraint {
    String message() default "{Invalid date of birth}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //3 property co ban cua 1 annotation

    int min(); //khai bao gtri toi thieu la bao nhieu
}
