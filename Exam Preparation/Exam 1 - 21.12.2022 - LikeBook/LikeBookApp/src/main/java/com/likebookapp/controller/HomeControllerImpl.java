package com.likebookapp.controller;

import com.likebookapp.model.dto.PostsDTO;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.service.PostServiceImpl;
import com.likebookapp.service.UserServiceImpl;
import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Set;

@Controller
public class HomeControllerImpl implements HomeController {

    private final LoggedUser loggedUser;
    private final PostServiceImpl postService;
    private final UserServiceImpl userService;
    public HomeControllerImpl(LoggedUser loggedUser, PostServiceImpl postService, UserServiceImpl userService) {
        this.loggedUser = loggedUser;
        this.postService = postService;
        this.userService = userService;
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
        // code

        Set<Post> postsFromLoggedUser = this.postService.getPostsFromUserById(loggedUser.getId());
        model.addAttribute("postsFromLoggedUser", postsFromLoggedUser);

        Set<PostsDTO> postsFromAnotherUser = this.postService.getPostsDTOSnotByUserID(loggedUser.getId());
        model.addAttribute("postsFromAnotherUser", postsFromAnotherUser);

        User user = this.userService.findUserById(loggedUser.getId());

        model.addAttribute("user", user);


        return "home";
    }

   
}

