package com.application.rest.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.application.rest.api.controller.dto.MakerDTO;
import com.application.rest.api.entities.Maker;
import com.application.rest.api.service.IMakerService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/api/makers")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder().id(maker.getId()).name(maker.getName())
                    .productList(maker.getProductList()).build();

            return ResponseEntity.ok(makerDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Maker not found");
        }
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<MakerDTO> makerList = makerService.findAll().stream().map(maker -> MakerDTO.builder().id(maker.getId())
                .name(maker.getName()).productList(maker.getProductList()).build()).toList();
        return ResponseEntity.ok(makerList);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) {
        if (makerDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().body("Maker name cannot be blank");
        }

        try {
            makerService.save(Maker.builder().name(makerDTO.getName()).build());
            return ResponseEntity.created(new URI("/api/makers")).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving the maker");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Maker successfully updated");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            makerService.deleteById(id);
            return ResponseEntity.ok("Maker deleted successfully");
        }

        return ResponseEntity.badRequest().build();
    }

}
