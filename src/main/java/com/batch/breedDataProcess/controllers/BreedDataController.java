package com.batch.breedDataProcess.controllers;

import com.batch.breedDataProcess.domain.BreedData;
import com.batch.breedDataProcess.repositories.BreedDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
