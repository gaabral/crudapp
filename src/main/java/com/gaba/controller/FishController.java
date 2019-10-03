package com.gaba.controller;

import com.gaba.ResourceNotFoundException;
import com.gaba.database.dao.FishRepository;
import com.gaba.database.entity.Fish;
import com.gaba.dtos.FishDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/fish")
@Slf4j
public class FishController {

    @Autowired
    FishRepository fishRepository;

    @GetMapping("{id}")
    public Fish getFish(@PathVariable Long id) throws ResourceNotFoundException {
        log.info("fish ------------> ");
        return fishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fish with id " + id + " was not found"));
    }

    @GetMapping()
    public Iterable<Fish> getFish() {
        log.info("fish ------------> ");
        return fishRepository.findAll();
    }

    @PostMapping()
    public Fish addFish(@RequestBody FishDTO fishDTO) {
        log.info("fish ------------> ");

        return fishRepository.save(Fish.builder()
                .color(fishDTO.getColor())
                .name(fishDTO.getName())
                .sex(fishDTO.getSex())
                .specie(fishDTO.getSpecie()).build());
    }

    @PutMapping("{id}")
    public Fish updateFish(@PathVariable @NotNull Long id, @RequestBody FishDTO fishDTO) throws ResourceNotFoundException {
        log.info("fish ------------> ");
        Fish found = fishRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Fish with id " + id + " was not found"));
        found.setSpecie(fishDTO.getSpecie());
        found.setColor(fishDTO.getColor());
        found.setName(fishDTO.getName());
        return fishRepository.save(found);
    }

    @DeleteMapping("{id}")
    public void deleteFish(@PathVariable @NotNull Long id) {
        log.info("fish ------------> ");
        fishRepository.deleteById(id);
    }



}
