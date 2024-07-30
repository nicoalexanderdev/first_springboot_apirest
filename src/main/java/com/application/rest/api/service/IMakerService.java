package com.application.rest.api.service;

import java.util.List;
import java.util.Optional;

import com.application.rest.api.entities.Maker;

public interface IMakerService {

    Optional<Maker> findById(Long id);

    List<Maker> findAll();

    void save(Maker maker);

    void deleteById(Long id);
}
