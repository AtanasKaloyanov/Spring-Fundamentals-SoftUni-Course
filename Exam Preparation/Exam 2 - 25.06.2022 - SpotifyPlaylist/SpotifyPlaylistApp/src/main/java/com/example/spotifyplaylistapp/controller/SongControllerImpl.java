package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.AddSongDTO;
import com.example.spotifyplaylistapp.service.SongServiceImpl;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongControllerImpl implements SongController {

    private final LoggedUser loggedUser;

    private final SongServiceImpl songService;

    public SongControllerImpl(LoggedUser loggedUser, SongServiceImpl songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @Override
    public String addSong() {

        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        return "song-add";
    }

    @Override
    public String addSong(@Valid AddSongDTO addSongDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSongDTO", addSongDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongDTO", bindingResult);

            return "redirect:/songs/song-add";
        }
// code

     this.songService.addSong(addSongDTO);
        return "redirect:/home";
    }

    @ModelAttribute
    public AddSongDTO addSongDTO() {
        return new AddSongDTO();
    }
}

