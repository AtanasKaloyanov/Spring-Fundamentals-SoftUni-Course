package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.service.SongServiceImpl;
import com.example.spotifyplaylistapp.service.StyleServiceImpl;
import com.example.spotifyplaylistapp.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final StyleServiceImpl styleService;

    private final UserServiceImpl userService;

    private final SongServiceImpl songService;

    public Init(StyleServiceImpl styleService, UserServiceImpl userService, SongServiceImpl songService) {
        this.styleService = styleService;
        this.userService = userService;
        this.songService = songService;
    }

    @Override
    public void run(String... args) throws Exception {
        styleService.initStyles();
        userService.initAdmin();
        userService.initTest();
        songService.initSongs();
    }
}
