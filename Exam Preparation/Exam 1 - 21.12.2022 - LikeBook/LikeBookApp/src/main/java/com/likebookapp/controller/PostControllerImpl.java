package com.likebookapp.controller;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.dto.RegisterDTO;
import com.likebookapp.service.PostServiceImpl;
import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PostControllerImpl implements PostController{

    private final LoggedUser loggedUser;

    private final PostServiceImpl postService;

    public PostControllerImpl(LoggedUser loggedUser, PostServiceImpl postService) {
        this.loggedUser = loggedUser;
        this.postService = postService;
    }

    @Override
    public String addPost() {

        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        return "post-add";
    }

    @Override
    public String addPost(@Valid AddPostDTO addPostDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPostDTO", addPostDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPostDTO", bindingResult);

            return "redirect:/posts/add-post";
        }

        addPostDTO.setId(loggedUser.getId());
        this.postService.savePosts(addPostDTO);
        //code
        return "redirect:/home";

    }

    @ModelAttribute
    public AddPostDTO addPostDTO() {
        return new AddPostDTO();
    }

    @Override
    public String removeByid(Long id) {
        this.postService.removePostById(id);
        return "redirect:/home";
    }

    @Override
    public String addLikeById(Long id) {
        this.postService.addLikeById(id);
        return "redirect:/home";
    }
}
