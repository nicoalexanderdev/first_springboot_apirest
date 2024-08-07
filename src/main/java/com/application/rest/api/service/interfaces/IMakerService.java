package com.application.rest.api.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.application.rest.api.presentation.dto.MakerDTO;

public interface IMakerService {

    List<MakerDTO> findAll();

    Optional<MakerDTO> findById(Long id);

    MakerDTO save(MakerDTO makerDTO);

    MakerDTO update(MakerDTO makerDTO, Long id);

    String deleteById(Long id);

}
