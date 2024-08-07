package com.application.rest.api.presentation.dto;

import java.util.ArrayList;
import java.util.List;

import com.application.rest.api.persistence.entities.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakerDTO {

    private Long id;
    private String name;

    private List<ProductEntity> productList = new ArrayList<>();

}
