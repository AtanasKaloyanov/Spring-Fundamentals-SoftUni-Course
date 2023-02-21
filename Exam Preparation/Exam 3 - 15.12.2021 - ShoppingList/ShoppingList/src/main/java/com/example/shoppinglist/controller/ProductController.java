package com.example.shoppinglist.controller;

import com.example.shoppinglist.dto.AddProductDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/products")
public interface ProductController {

    @GetMapping("/product-add")
    String addProduct();

    @PostMapping("/product-add")
    String addProduct(@Valid AddProductDTO addPostDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes);
}

