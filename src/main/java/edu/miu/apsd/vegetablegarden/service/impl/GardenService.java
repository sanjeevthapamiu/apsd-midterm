package edu.miu.apsd.vegetablegarden.service.impl;

import edu.miu.apsd.vegetablegarden.model.Garden;
import edu.miu.apsd.vegetablegarden.repository.GardenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenService {

    private final GardenRepository repository;

    public void create(Garden garden) {
        repository.save(garden);
    }

    public Optional<Garden> getByName(String name) {
        return repository.findByName(name);
    }

    public void update(String name, Garden garden) {
        getByName(name).ifPresent(p -> repository.save(garden));
    }

    public void delete(String name) {
        getByName(name).ifPresent(repository::delete);
    }

}
