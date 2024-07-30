package com.application.rest.api.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.rest.api.entities.Maker;
import com.application.rest.api.persistence.IMakerDAO;
import com.application.rest.api.repository.MakerRepository;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository repository;

    @Override
    public Optional<Maker> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) repository.findAll();
    }

    @Override
    public void save(Maker maker) {
        repository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
