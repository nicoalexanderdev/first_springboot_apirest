package com.application.rest.api.service.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.api.persistence.entities.CategoryEntity;
import com.application.rest.api.persistence.repository.ICategoryRepository;
import com.application.rest.api.presentation.dto.CategoryDTO;
import com.application.rest.api.service.interfaces.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<CategoryDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return repository.findAll()
                .stream()
                .map(entity -> modelMapper
                        .map(entity, CategoryDTO.class))
                .toList();
    }

    @Override
    public CategoryDTO findById(Long id) {
        Optional<CategoryEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            CategoryEntity currentCategory = entity.get();
            CategoryDTO categoryDTO = modelMapper.map(currentCategory, CategoryDTO.class);
            return categoryDTO;
        }

        return new CategoryDTO();
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            CategoryEntity newCategoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);
            repository.save(newCategoryEntity);
            return categoryDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error creating category");
        }
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO, Long id) {
        Optional<CategoryEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            CategoryEntity currentCategory = entity.get();
            currentCategory.setName(categoryDTO.getName());

            repository.save(currentCategory);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentCategory, CategoryDTO.class);
        }

        throw new UnsupportedOperationException("Error updating Category");
    }

    @Override
    public String deleteById(Long id) {
        Optional<CategoryEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            CategoryEntity currentCategory = entity.get();
            repository.delete(currentCategory);
            return "Category with ID " + id + " deleted.";
        }

        return "Category with ID " + id + " not found.";
    }

}
