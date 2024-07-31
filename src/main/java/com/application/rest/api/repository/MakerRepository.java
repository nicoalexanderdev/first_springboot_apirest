package com.application.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.rest.api.entities.Maker;

public interface MakerRepository extends JpaRepository<Maker, Long> {

}
