package com.application.rest.api.persistence;

import java.util.List;
import java.util.Optional;

import com.application.rest.api.entities.Maker;

public interface IMakerDAO {

    Optional<Maker> findById(Long id);

    List<Maker> findAll();

    void save(Maker maker);

    void deleteById(Long id);
}
