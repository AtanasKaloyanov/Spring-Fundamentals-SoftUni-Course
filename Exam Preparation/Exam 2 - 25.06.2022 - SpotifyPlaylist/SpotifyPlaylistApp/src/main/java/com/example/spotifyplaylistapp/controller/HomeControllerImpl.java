package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.SongDTO;
import com.example.spotifyplaylistapp.model.dto.SongsByGenreDTO;
import com.example.spotifyplaylistapp.service.SongServiceImpl;
import com.example.spotifyplaylistapp.service.UserServiceImpl;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class HomeControllerImpl implements HomeController {

    private final LoggedUser loggedUser;

    private final SongServiceImpl songService;
    private final UserServiceImpl userService;

    public HomeControllerImpl(LoggedUser loggedUser, SongServiceImpl songService, UserServiceImpl userService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
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

        SongsByGenreDTO songsByGenreDTO = this.songService.getAllSongsByGEnreDTO();
        model.addAttribute("songsByGenreDTO", songsByGenreDTO);

        Set<SongDTO> playlist = this.songService.getPlaylist(this.loggedUser.getId());
        model.addAttribute("playlist", playlist);


        // code
        return "home";
    }

    @Override
    public String addSongToPlayList(Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.songService.addSong(id, loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String removeAllSongs() {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.userService.deleteAllSongs(loggedUser.getId());
        return "redirect:/home";
    }


}

