package com.application.rest.api.service;

import java.util.List;
import java.util.Optional;

import com.application.rest.api.entities.Category;

public interface ICategoryService {

    Optional<Category> findById(Long id);

    List<Category> findAll();

    void deleteById(Long id);

    void save(Category category);
}
