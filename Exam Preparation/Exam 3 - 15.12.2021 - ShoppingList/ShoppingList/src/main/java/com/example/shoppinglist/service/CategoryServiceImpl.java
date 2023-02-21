package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Category;
import com.example.shoppinglist.model.NameEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategory() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(NameEnum.values()).forEach(
                currentEnum -> {
                    Category currentCategory = new Category();
                    currentCategory.setName(currentEnum);
                    currentCategory.setDescription("...");

                    this.categoryRepository.save(currentCategory);
                });
    }
}
