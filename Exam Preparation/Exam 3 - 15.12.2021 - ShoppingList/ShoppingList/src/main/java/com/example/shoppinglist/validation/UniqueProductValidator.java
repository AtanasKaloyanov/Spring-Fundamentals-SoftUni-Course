package com.example.shoppinglist.validation;

import com.example.shoppinglist.service.ProductServiceImpl;
import com.example.shoppinglist.validation.annotation.UniqueProduct;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueProductValidator implements ConstraintValidator<UniqueProduct, String> {

    private final ProductServiceImpl productService;

    public UniqueProductValidator(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.productService.findProductByname(value) == null;
    }
}

