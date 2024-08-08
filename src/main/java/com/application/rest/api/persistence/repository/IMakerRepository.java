package com.application.rest.api.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.rest.api.persistence.entities.MakerEntity;

@Repository
public interface IMakerRepository extends JpaRepository<MakerEntity, Long> {

    Optional<MakerEntity> findByNameIgnoreCase(String name);

}
