package edu.miu.apsd.vegetablegarden.service.impl;

import edu.miu.apsd.vegetablegarden.model.Plant;
import edu.miu.apsd.vegetablegarden.repository.PlantRepository;
import edu.miu.apsd.vegetablegarden.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository repository;

    @Override
    public List<Plant> getAllPlantsSortedByName() {
        return repository.findAllByOrderByName();
    }

    @Override
    public List<Plant> getAllPlantsSortedByPlantDate() {
        return repository.findAllByOrderByPlantDate();
    }

    @Override
    public List<Plant> getAllPlants() {
        return repository.findAll();
    }

    @Override
    public void save(Plant plant) {
        repository.save(plant);
    }

    @Override
    public Optional<Plant> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void update(Plant plant) {
        repository.findById(plant.getId())
                .ifPresent(p -> repository.save(plant));
    }

    @Override
    public void deleteByName(String name) {
        getByName(name).ifPresent(repository::delete);
    }
}
