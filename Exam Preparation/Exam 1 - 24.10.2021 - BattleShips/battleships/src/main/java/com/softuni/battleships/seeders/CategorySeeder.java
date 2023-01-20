package com.softuni.battleships.seeders;

import com.softuni.battleships.models.Category;
import com.softuni.battleships.models.enums.Name;
import com.softuni.battleships.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {

            List<Category> categories = Arrays.stream(Name.values())
                    .map(categoryName -> new Category(categoryName))
                    .toList();

            this.categoryRepository.saveAll(categories);
        }

    }
}

