package com.likebookapp.controller;

import com.likebookapp.model.dto.AddPostDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/posts")
public interface PostController {

    @GetMapping("/add-post")
    String addPost();

    @PostMapping("/add-post")
    String addPost(@Valid AddPostDTO addPostDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes);

    @GetMapping("remove/{id}")
    String removeByid(@PathVariable Long id);

    @GetMapping("add-like/{id}")
    String addLikeById(@ PathVariable Long id);
}


