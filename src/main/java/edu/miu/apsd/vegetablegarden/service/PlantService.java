package edu.miu.apsd.vegetablegarden.service;

import edu.miu.apsd.vegetablegarden.model.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {
    List<Plant> getAllPlantsSortedByName();

    List<Plant> getAllPlantsSortedByPlantDate();

    List<Plant> getAllPlants();

    void save(Plant plant);

    Optional<Plant> getByName(String name);

    void update(Plant plant);

    void deleteByName(String name);
}
