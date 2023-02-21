package com.example.shoppinglist.validation.annotation;

import com.example.shoppinglist.validation.UniqueProductValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueProductValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueProduct {
    String message() default "Product name arleady exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

