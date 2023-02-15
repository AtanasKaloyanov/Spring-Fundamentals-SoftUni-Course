package com.likebookapp.model.dto;

import com.likebookapp.model.entity.MoodsEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddPostDTO {
    private Long id;

    @Size(min = 2, max = 150)
    @NotNull
    private String content;
    @NotNull
    private MoodsEnum moodsName;

    public AddPostDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodsEnum getMoodsName() {
        return moodsName;
    }

    public void setMoodsName(MoodsEnum moodsName) {
        this.moodsName = moodsName;
    }
}
