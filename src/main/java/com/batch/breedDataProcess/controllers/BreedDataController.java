package com.batch.breedDataProcess.controllers;

import com.batch.breedDataProcess.domain.BreedData;
import com.batch.breedDataProcess.repositories.BreedDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/info/breed")
public class BreedDataController {
    @Autowired
    BreedDataRepository repository;

    @GetMapping
    public List<BreedData> getAllBreedNames() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody BreedData getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{breedName}")
    public @ResponseBody List<BreedData> findAllByName(@PathVariable String breedName) {
        return repository.findAllByBreed_name(breedName);
    }



}
