package com.example.shoppinglist.service;

import com.example.shoppinglist.dto.AddProductDTO;
import com.example.shoppinglist.dto.ProductDTO;
import com.example.shoppinglist.dto.ProductsByCategoryDTO;
import com.example.shoppinglist.model.Category;
import com.example.shoppinglist.model.NameEnum;
import com.example.shoppinglist.model.Product;
import com.example.shoppinglist.repository.CategoryRepository;
import com.example.shoppinglist.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;

        this.categoryRepository = categoryRepository;
    }

    private ProductDTO mapProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public ProductDTO findProductByname(String productName) {
        Product product = this.productRepository.findByName(productName).orElse(null);
        if (product == null) {
            return null;
        }

        return this.mapProductDTO(product);
    }
    public Product mapProduct(AddProductDTO addProductDTO) {
        Product product = new Product();
        product.setName(addProductDTO.getName());
        product.setDescription(addProductDTO.getDescription());
        product.setPrice(addProductDTO.getPrice());
        product.setNeededBefore(addProductDTO.getNeededBefore());

        String name = addProductDTO.getCategory();
        NameEnum nameEnum = NameEnum.valueOf(name);
        Category category = this.categoryRepository.findByName(nameEnum).orElse(null);
        product.setCategory(category);

        return product;
    }

    public void saveProduct(AddProductDTO addProductDTO) {
        this.productRepository.save(mapProduct(addProductDTO));
    }

    public void initElements() {
        Product first = new Product();
        first.setName("aaa");
        first.setDescription("aaa");
        first.setPrice(1);
        first.setNeededBefore(LocalDateTime.now());

        Category one = this.categoryRepository.findByName(NameEnum.FOOD).orElse(null);
        first.setCategory(one);

        Product second = new Product();
        second.setName("bbb");
        second.setDescription("bbb");
        second.setPrice(1);
        second.setNeededBefore(LocalDateTime.now());

        Category two = this.categoryRepository.findByName(NameEnum.DRINK).orElse(null);
        second.setCategory(two);

        Product third = new Product();
        third.setName("ccc");
        third.setDescription("ccc");
        third.setPrice(1);
        third.setNeededBefore(LocalDateTime.now());

        Category three = this.categoryRepository.findByName(NameEnum.HOUSE).orElse(null);
        third.setCategory(three);

        Product fourth = new Product();
        fourth.setName("ddd");
        fourth.setDescription("ddd");
        fourth.setPrice(1);
        fourth.setNeededBefore(LocalDateTime.now());

        Category four = this.categoryRepository.findByName(NameEnum.OTHER).orElse(null);
        fourth.setCategory(four);

        this.productRepository.saveAndFlush(first);
        this.productRepository.saveAndFlush(second);
        this.productRepository.saveAndFlush(third);
        this.productRepository.saveAndFlush(fourth);
    }
// mapper
    public ProductDTO mapperToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    // category -> Set<Product>    Set<Product> -> Set<ProductDTOs>
    public Set<ProductDTO> findProductsByCategory(Category category) {
        Set<Product> productsByCategory = this.productRepository.findAllByCategory(category);

        Set<ProductDTO> productDTOS = productsByCategory
                .stream()
                .map(this::mapperToDTO)
                .collect(Collectors.toSet());

        return productDTOS;
    }

    public ProductsByCategoryDTO getAllProducts() {
        ProductsByCategoryDTO products = new ProductsByCategoryDTO();

        Category first = this.categoryRepository.findByName(NameEnum.FOOD).orElse(null);
        Set<ProductDTO> foods = findProductsByCategory(first);
        products.setFoods(foods);

        Category second = this.categoryRepository.findByName(NameEnum.HOUSE).orElse(null);
        Set<ProductDTO> houses = findProductsByCategory(second);
        products.setHouseholds(houses);

        Category third = this.categoryRepository.findByName(NameEnum.OTHER).orElse(null);
        Set<ProductDTO> others = findProductsByCategory(third);
        products.setOthers(others);

        Category fourth = this.categoryRepository.findByName(NameEnum.DRINK).orElse(null);
        Set<ProductDTO> drinks = findProductsByCategory(fourth);
        products.setDrinks(drinks);

        return products;
    }

    public String getFinalSum() {
        ProductsByCategoryDTO products = getAllProducts();
        double sum = 0;
        for (ProductDTO other : products.getOthers()) {
            sum += other.getPrice();
        }

        for (ProductDTO drink : products.getDrinks()) {
            sum += drink.getPrice();
        }

        for (ProductDTO houseHold : products.getHouseholds()) {
            sum += houseHold.getPrice();
        }

        for (ProductDTO food : products.getFoods()) {
            sum += food.getPrice();
        }

        return String.format("%.2f", sum);
    }

    public void buyItem(Long id) {
        this.productRepository.deleteById(id);
    }

    public void deleteAllItems() {
        this.productRepository.deleteAll();
    }

//    public void
}