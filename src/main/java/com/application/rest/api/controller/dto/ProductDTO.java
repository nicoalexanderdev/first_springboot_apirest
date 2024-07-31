package com.application.rest.api.controller.dto;

import java.math.BigDecimal;

import com.application.rest.api.entities.Category;
import com.application.rest.api.entities.Maker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Maker maker;
    private Category category;
}
