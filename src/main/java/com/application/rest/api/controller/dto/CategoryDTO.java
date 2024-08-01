package com.application.rest.api.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.application.rest.api.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();

}
