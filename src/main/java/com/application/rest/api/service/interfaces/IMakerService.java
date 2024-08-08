package com.application.rest.api.service.interfaces;

import java.util.List;

import com.application.rest.api.presentation.dto.MakerDTO;

public interface IMakerService {

    List<MakerDTO> findAll();

    MakerDTO findById(Long id);

    MakerDTO save(MakerDTO makerDTO);

    MakerDTO update(MakerDTO makerDTO, Long id);

    String deleteById(Long id);

    MakerDTO findByNameIgnoreCase(String query);

}
