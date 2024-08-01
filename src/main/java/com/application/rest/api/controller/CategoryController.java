package com.application.rest.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.rest.api.controller.dto.CategoryDTO;
import com.application.rest.api.entities.Category;
import com.application.rest.api.service.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();

            CategoryDTO categoryDTO = CategoryDTO.builder().id(category.getId()).name(category.getName())
                    .productList(category.getProductList()).build();

            return ResponseEntity.ok(categoryDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<CategoryDTO> categoryList = categoryService.findAll().stream().map(category -> CategoryDTO.builder()
                .id(category.getId()).name(category.getName()).productList(category.getProductList()).build()).toList();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO) {

        if (categoryDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().body("Category name cannot be blank");
        }

        try {
            categoryService.save(Category.builder().name(categoryDTO.getName()).build());
            return ResponseEntity.created(new URI("/api/categories")).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving the category");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDTO.getName());
            categoryService.save(category);
            return ResponseEntity.ok().body("Category successfully updated");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletebyId(@PathVariable Long id) {

        if (id != null) {
            categoryService.deleteById(id);
            return ResponseEntity.ok().body("Category successfully deleted");
        }

        return ResponseEntity.badRequest().build();

    }

}
