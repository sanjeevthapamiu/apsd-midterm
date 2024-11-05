package edu.miu.apsd.vegetablegarden.service;

import edu.miu.apsd.vegetablegarden.model.Garden;

import java.util.List;
import java.util.Optional;

public interface GardenService {
    List<Garden> getAllGardens();

    void save(Garden garden);

    void saveAll(List<Garden> gardens);

    Optional<Garden> getByName(String name);

    void update(Garden garden);

    void deleteByName(String name);
}
