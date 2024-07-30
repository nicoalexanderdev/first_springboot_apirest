package com.application.rest.api.persistence.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.rest.api.entities.Product;
import com.application.rest.api.persistence.IProductDAO;
import com.application.rest.api.repository.ProductRepository;

@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return (List<Product>) repository.findProductByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByMaker(String nameMaker) {
        return (List<Product>) repository.findByMaker_Name(nameMaker);
    }

    @Override
    public List<Product> findByCategory(String nameCategory) {
        return (List<Product>) repository.findByCategory_Name(nameCategory);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

}
