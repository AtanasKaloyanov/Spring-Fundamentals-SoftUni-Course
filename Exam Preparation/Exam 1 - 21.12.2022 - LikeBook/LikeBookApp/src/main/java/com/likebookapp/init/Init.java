package com.likebookapp.init;

import com.likebookapp.service.MoodServiceImpl;
import com.likebookapp.service.PostServiceImpl;
import com.likebookapp.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final MoodServiceImpl moodService;
    private final UserServiceImpl userService;

    private final PostServiceImpl postService;

    public Init(MoodServiceImpl moodService, UserServiceImpl userService, PostServiceImpl postService) {
        this.moodService = moodService;

        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {
        moodService.enumsInit();
        userService.initAdmin();
        userService.initTest();


        postService.initPosts();
    }
}
