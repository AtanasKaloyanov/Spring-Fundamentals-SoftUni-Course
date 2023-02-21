package com.example.shoppinglist.init;

import com.example.shoppinglist.service.CategoryServiceImpl;
import com.example.shoppinglist.service.ProductServiceImpl;
import com.example.shoppinglist.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class Init implements CommandLineRunner {
    private final CategoryServiceImpl categoryService;
    private final UserServiceImpl userService;

    private final ProductServiceImpl productService;

    public Init(CategoryServiceImpl categoryService, UserServiceImpl userService, ProductServiceImpl productService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.initCategory();
        userService.initAdmin();
        userService.initTest();
        productService.initElements();

    }
}
