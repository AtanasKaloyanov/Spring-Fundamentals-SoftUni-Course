package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.AddSongDTO;
import com.example.spotifyplaylistapp.model.dto.SongDTO;
import com.example.spotifyplaylistapp.model.dto.SongsByGenreDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleEnum;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl {
    private final SongRepository songRepository;
    private final StyleRepository styleRepository;

    private final UserRepository userRepository;

    public SongServiceImpl(SongRepository songRepository, StyleServiceImpl styleService, StyleRepository styleRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
    }

    public void addSong(AddSongDTO addSongDTO) {
        Song song = new Song();
        song.setPerformer(addSongDTO.getPerformer());
        song.setTitle(addSongDTO.getTitle());
        song.setDuration(addSongDTO.getDuration());
        song.setReleaseDate(addSongDTO.getReleaseDate());

        Style style = this.styleRepository.findByStyleEnum(addSongDTO.getStyleEnum());
        song.setStyle(style);

        this.songRepository.save(song);
    }

    public void initSongs() {
        Song firstSong = new Song();
        firstSong.setPerformer("ccc");
        firstSong.setTitle("ccc");
        firstSong.setDuration(Long.parseLong("200"));
        Style style = this.styleRepository.findByStyleEnum(StyleEnum.POP);
        firstSong.setStyle(style);

        Song secondSong = new Song();
        secondSong.setPerformer("ddd");
        secondSong.setTitle("ddd");
        secondSong.setDuration(Long.parseLong("200"));
        Style secondStyle = this.styleRepository.findByStyleEnum(StyleEnum.ROCK);
        secondSong.setStyle(secondStyle);

        Song thirdSong = new Song();
        thirdSong.setPerformer("eee");
        thirdSong.setTitle("eee");
        thirdSong.setDuration(Long.parseLong("200"));
        Style thirdStyle = this.styleRepository.findByStyleEnum(StyleEnum.JAZZ);
        thirdSong.setStyle(thirdStyle);

        this.songRepository.save(firstSong);
        this.songRepository.save(secondSong);
        this.songRepository.save(thirdSong);
    }

    // Лявата част на екрана SongsByStyleDTO, в което има  Set<SongDTO>, Set<SongDTO>, Set<SongDTO>
    // А за всеки SongDTO -> id, performer, title, duration

    // приемане на song и превръщанетo и в songDTO. Връщане на това SongDTO
    private SongDTO mapSongDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setId(song.getId());
        songDTO.setPerformer(song.getPerformer());
        songDTO.setTitle(song.getTitle());
        songDTO.setDuration(song.getDuration());
        return songDTO;
    }

    // Създаване на Set<Song> по Style style и превръщането на този сет в Set<SongDTO>
    public Set<SongDTO> findSongsByStyle(Style style) {
        Set<Song> songsByStyle = this.songRepository.findAllByStyle(style);

        Set<SongDTO> songsDTOByStyleSet = songsByStyle
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toSet());

        return songsDTOByStyleSet;
    }

    // Създаване на SongsByStyleDTO, към който се добавят всички
    // поп песни, всички джаз песни и всички rock песни:

    public SongsByGenreDTO getAllSongsByGEnreDTO() {
        SongsByGenreDTO songs = new SongsByGenreDTO();

        Style poppStyle = this.styleRepository.findByStyleEnum(StyleEnum.POP);
        Set<SongDTO> popSongsSet = findSongsByStyle(poppStyle);
        songs.setPopSongs(popSongsSet);

        Style jazzStyle = this.styleRepository.findByStyleEnum(StyleEnum.JAZZ);
        Set<SongDTO> jazzSongSet = findSongsByStyle(jazzStyle);
        songs.setJazzSongs(jazzSongSet);

        Style rockStyle = this.styleRepository.findByStyleEnum(StyleEnum.ROCK);
        Set<SongDTO> rockSongSet = findSongsByStyle(rockStyle);
        songs.setRockSongs(rockSongSet);

        return songs;
    }

    // взимане на Set<Song> по id на User и превръщането им в Set<SongDTO>
    public Set<SongDTO> getPlaylist(Long id) {
        Set<SongDTO> userPlaylist =
                this.songRepository.findAllByUserId(id)
                        .stream().map(this::mapSongDTO)
                        .collect(Collectors.toSet());

        return userPlaylist;
    }

    public void addSong(Long songId, Long userId) {
        Song song = this.songRepository.findById(songId).orElse(null);
        User user = this.userRepository.findById(userId).orElse(null);
        user.getSongs().add(song);
        this.userRepository.save(user);

    }

}

