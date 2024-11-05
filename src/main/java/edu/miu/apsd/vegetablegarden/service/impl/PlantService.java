package edu.miu.apsd.vegetablegarden.service.impl;

import edu.miu.apsd.vegetablegarden.model.Plant;
import edu.miu.apsd.vegetablegarden.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository repository;

    public List<Plant> getAllPlantsSortedByName() {
        return repository.findAllByOrderByName();
    }

    public List<Plant> getAllPlantsSortedByPlantDate() {
        return repository.findAllByOrderByPlantDate();
    }

    public List<Plant> getAllPlants() {
        return repository.findAll();
    }

    public void save(Plant plant) {
        repository.save(plant);
    }

    public Optional<Plant> getByName(String name) {
        return repository.findByName(name);
    }

    public void update(Plant plant) {
        repository.findById(plant.getId())
                .ifPresent(p -> repository.save(plant));
    }

    public void deleteByName(String name) {
        getByName(name).ifPresent(repository::delete);
    }
}
