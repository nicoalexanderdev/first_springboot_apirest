package com.application.rest.api.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.rest.api.presentation.dto.MakerDTO;
import com.application.rest.api.service.interfaces.IMakerService;

@RestController
@RequestMapping("/api/v1/makers")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    // find all
    @GetMapping
    public ResponseEntity<List<MakerDTO>> findAll() {
        return new ResponseEntity<>(makerService.findAll(), HttpStatus.OK);
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<MakerDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(makerService.findById(id), HttpStatus.OK);
    }

    // create
    @PostMapping
    public ResponseEntity<MakerDTO> save(@RequestBody MakerDTO makerDTO) {
        return new ResponseEntity<>(makerService.save(makerDTO), HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<MakerDTO> update(@RequestBody MakerDTO makerDTO, @PathVariable Long id) {
        return new ResponseEntity<>(makerService.update(makerDTO, id), HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delteById(@PathVariable Long id) {
        return new ResponseEntity<>(makerService.deleteById(id), HttpStatus.NO_CONTENT);
    }

    // search by name
    @GetMapping("/search")
    public ResponseEntity<MakerDTO> findByName(@RequestParam String query) {
        return new ResponseEntity<>(makerService.findByNameIgnoreCase(query), HttpStatus.OK);
    }
}
