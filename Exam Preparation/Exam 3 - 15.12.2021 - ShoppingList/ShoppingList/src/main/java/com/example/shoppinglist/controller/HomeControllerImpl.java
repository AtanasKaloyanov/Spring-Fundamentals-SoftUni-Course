package com.example.shoppinglist.controller;

import com.example.shoppinglist.dto.ProductDTO;
import com.example.shoppinglist.dto.ProductsByCategoryDTO;
import com.example.shoppinglist.service.ProductServiceImpl;
import com.example.shoppinglist.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Set;

@Controller
public class HomeControllerImpl implements HomeController {

    private final LoggedUser loggedUser;

    private final ProductServiceImpl productService;
    public HomeControllerImpl(LoggedUser loggedUser, ProductServiceImpl productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
    }

    @Override
    public String index() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @Override
    public String home(Model model) {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        ProductsByCategoryDTO allProducts = this.productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);

        String sum = this.productService.getFinalSum();
        model.addAttribute("sum", sum);

       return "home";
    }

    @Override
    public String buyItem(Long id) {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.productService.buyItem(loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String deleteAllItems() {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.productService.deleteAllItems();
        return "redirect:/home";
    }
}

