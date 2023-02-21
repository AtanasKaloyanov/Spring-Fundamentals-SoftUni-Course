package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService{
    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {
        if (styleRepository.count() != 0) {
            return;
        }

        Arrays.stream(StyleEnum.values()).forEach(
                currentEnum -> {
                    Style currentStyle = new Style();

                    currentStyle.setStyleEnum(currentEnum);
                    currentStyle.setDescription("...");

                    this.styleRepository.save(currentStyle);
                });

    }
}
