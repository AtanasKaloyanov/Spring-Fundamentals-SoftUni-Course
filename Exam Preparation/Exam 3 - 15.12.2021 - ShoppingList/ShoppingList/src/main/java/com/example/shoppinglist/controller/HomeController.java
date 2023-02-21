package com.example.shoppinglist.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping(name = "/")
public interface HomeController {
    @GetMapping
    String index();

    @GetMapping("/home")
    String home(Model model);

    @GetMapping("/home/buy/{id}")
   String buyItem(@PathVariable Long id);

    @GetMapping("/home/delete-all")
    String deleteAllItems();

}

