package com.application.rest.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.api.entities.Category;
import com.application.rest.api.persistence.ICategoryDAO;
import com.application.rest.api.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryDAO.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public void deleteById(Long id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public void save(Category category) {
        categoryDAO.save(category);
    }

}
