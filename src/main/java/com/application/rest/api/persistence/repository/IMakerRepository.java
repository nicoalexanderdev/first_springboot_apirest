package com.application.rest.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.rest.api.persistence.entities.MakerEntity;

@Repository
public interface IMakerRepository extends JpaRepository<MakerEntity, Long> {

}
