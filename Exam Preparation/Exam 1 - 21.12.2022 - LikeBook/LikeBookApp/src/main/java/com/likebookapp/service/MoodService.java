package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodsEnum;

public interface MoodService {

    void enumsInit();

    Mood findMoodByMoodName(MoodsEnum moodsEnum);
}
