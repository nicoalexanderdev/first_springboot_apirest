package com.application.rest.api.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.api.entities.Product;
import com.application.rest.api.persistence.IProductDAO;
import com.application.rest.api.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByMaker(String nameMaker) {
        return productDAO.findByMaker(nameMaker);
    }

    @Override
    public List<Product> findByCategory(String nameCategory) {
        return productDAO.findByCategory(nameCategory);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

}
