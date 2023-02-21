package com.example.shoppinglist.controller;

import com.example.shoppinglist.dto.AddProductDTO;
import com.example.shoppinglist.service.ProductServiceImpl;
import com.example.shoppinglist.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    @Controller
    public class ProductControllerImpl implements ProductController {
        private final LoggedUser loggedUser;
        private final ProductServiceImpl productService;

        public ProductControllerImpl(LoggedUser loggedUser, ProductServiceImpl productService) {
            this.loggedUser = loggedUser;
            this.productService = productService;
            ;
        }

        @Override
        public String addProduct() {

            if (!loggedUser.isLogged()) {
                return "redirect:/users/login";
            }

            return "product-add";
        }

        @Override
        public String addProduct(@Valid AddProductDTO addProductDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("addProductDTO", addProductDTO);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProductDTO", bindingResult);

                return "redirect:/products/product-add";
            }

             this.productService.saveProduct(addProductDTO);
            //code
            return "redirect:/home";
        }



        @ModelAttribute
        public AddProductDTO addProductDTO() {
            return new AddProductDTO();
        }
    }


