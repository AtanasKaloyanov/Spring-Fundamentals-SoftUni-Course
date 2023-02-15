package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodsEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService{

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void enumsInit() {
        Arrays.stream(MoodsEnum.values()).forEach(
            currentEnum -> {
                Mood mood = new Mood();
                mood.setMoodName(currentEnum);
                mood.setDescription("...");

                this.moodRepository.save(mood);

            }
        );


    }

    @Override
    public Mood findMoodByMoodName(MoodsEnum moodsEnum) {
        return this.moodRepository.findMoodByMoodName(moodsEnum);
    }
}
