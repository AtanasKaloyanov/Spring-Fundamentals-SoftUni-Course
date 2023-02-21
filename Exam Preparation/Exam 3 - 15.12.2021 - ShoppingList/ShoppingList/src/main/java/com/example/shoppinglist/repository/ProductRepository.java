package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.Category;
import com.example.shoppinglist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String productName);
    Set<Product> findAllByCategory(Category category);

}
