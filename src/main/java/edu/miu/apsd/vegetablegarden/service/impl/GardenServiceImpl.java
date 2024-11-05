package edu.miu.apsd.vegetablegarden.service.impl;

import edu.miu.apsd.vegetablegarden.model.Garden;
import edu.miu.apsd.vegetablegarden.repository.GardenRepository;
import edu.miu.apsd.vegetablegarden.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {

    private final GardenRepository repository;

    @Override
    public List<Garden> getAllGardens() {
        return repository.findAll();
    }

    @Override
    public void save(Garden garden) {
        repository.save(garden);
    }

    @Override
    public void saveAll(List<Garden> gardens) {
        repository.saveAll(gardens);
    }

    @Override
    public Optional<Garden> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void update(Garden garden) {
        repository.findById(garden.getId())
                .ifPresent(p -> repository.save(garden));
    }

    @Override
    public void deleteByName(String name) {
        getByName(name).ifPresent(repository::delete);
    }

}
