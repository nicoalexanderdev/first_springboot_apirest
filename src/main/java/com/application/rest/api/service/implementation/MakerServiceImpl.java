package com.application.rest.api.service.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.api.persistence.entities.MakerEntity;
import com.application.rest.api.persistence.repository.IMakerRepository;
import com.application.rest.api.presentation.dto.MakerDTO;
import com.application.rest.api.service.interfaces.IMakerService;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerRepository repository;

    @Override
    public List<MakerDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();

        return repository.findAll().stream().map(entity -> modelMapper.map(entity, MakerDTO.class)).toList();
    }

    @Override
    public MakerDTO findById(Long id) {

        Optional<MakerEntity> makerEntity = repository.findById(id);

        if (makerEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            MakerEntity currentMaker = makerEntity.get();
            return modelMapper.map(currentMaker, MakerDTO.class);
        }

        return new MakerDTO();

    }

    @Override
    public MakerDTO save(MakerDTO makerDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            MakerEntity makerEntity = modelMapper.map(makerDTO, MakerEntity.class);
            repository.save(makerEntity);
            return makerDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error creating Maker");
        }
    }

    @Override
    public MakerDTO update(MakerDTO makerDTO, Long id) {
        Optional<MakerEntity> makerEntity = repository.findById(id);

        if (makerEntity.isPresent()) {
            MakerEntity currentMaker = makerEntity.get();
            currentMaker.setName(makerDTO.getName());

            repository.save(currentMaker);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentMaker, MakerDTO.class);
        } else {
            throw new UnsupportedOperationException("Error updating Maker");
        }

    }

    @Override
    public String deleteById(Long id) {
        Optional<MakerEntity> makerEntity = repository.findById(id);

        if (makerEntity.isPresent()) {
            MakerEntity curreEntity = makerEntity.get();
            repository.delete(curreEntity);
            return "Maker with Id " + id + " deleted.";
        } else {
            return "Maker with Id " + id + " not found.";
        }
    }

    public MakerDTO findByNameIgnoreCase(String query) {
        Optional<MakerEntity> makerEntity = repository.findByNameIgnoreCase(query);

        if (makerEntity.isPresent()) {
            MakerEntity currentMaker = makerEntity.get();
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentMaker, MakerDTO.class);
        }

        return new MakerDTO();
    }

}
