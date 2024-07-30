package com.application.rest.api.persistence;

import java.util.List;
import java.util.Optional;

import com.application.rest.api.entities.Category;

public interface ICategoryDAO {

    Optional<Category> findById(Long id);

    List<Category> findAll();

    void deleteById(Long id);

    void save(Category category);
}
