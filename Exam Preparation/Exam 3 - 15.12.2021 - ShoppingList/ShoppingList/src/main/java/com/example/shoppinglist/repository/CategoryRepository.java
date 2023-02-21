package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.Category;
import com.example.shoppinglist.model.NameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
Optional<Category> findByName(NameEnum name);
Set<Category> findAllByName(NameEnum nameEnum);

}
