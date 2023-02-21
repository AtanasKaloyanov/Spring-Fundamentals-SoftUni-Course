package com.example.spotifyplaylistapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping(name = "/")
public interface HomeController {
    @GetMapping
    String index();

    @GetMapping("/home")
    String home(Model model);

    @GetMapping("/home/add-song-to-playlist/{id}")
    String addSongToPlayList(@PathVariable ("id") Long id);

    @GetMapping("home/remove-all-songs-from-playlist")
    String removeAllSongs();


}

