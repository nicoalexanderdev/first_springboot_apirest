package com.application.rest.api.service.interfaces;

import java.util.List;

import com.application.rest.api.presentation.dto.CategoryDTO;

public interface ICategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findById(Long id);

    CategoryDTO save(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO, Long id);

    String deleteById(Long id);
}
