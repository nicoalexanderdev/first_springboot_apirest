package com.application.rest.api.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.rest.api.entities.Category;
import com.application.rest.api.persistence.ICategoryDAO;
import com.application.rest.api.repository.CategoryRepository;

@Component
public class CategoryDAOImpl implements ICategoryDAO {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

}
