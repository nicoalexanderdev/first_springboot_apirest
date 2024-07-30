package com.application.rest.api.persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.application.rest.api.entities.Product;

public interface IProductDAO {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByMaker(String nameMaker);

    List<Product> findByCategory(String nameCategory);

    void deleteById(Long id);

    void save(Product product);
}
