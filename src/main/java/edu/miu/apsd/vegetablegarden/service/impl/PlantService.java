package edu.miu.apsd.vegetablegarden.service.impl;

import edu.miu.apsd.vegetablegarden.model.Plant;
import edu.miu.apsd.vegetablegarden.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository repository;

    public void create(Plant plant) {
        repository.save(plant);
    }

    public Optional<Plant> getByName(String name) {
        return repository.findByName(name);
    }

    public void update(String name, Plant plant) {
        getByName(name).ifPresent(p -> repository.save(plant));
    }

    public void delete(String name) {
        getByName(name).ifPresent(repository::delete);
    }
}
