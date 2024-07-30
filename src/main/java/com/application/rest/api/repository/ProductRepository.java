package com.application.rest.api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.rest.api.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByMaker_Name(String maker);

    List<Product> findByCategory_Name(String category);
}
