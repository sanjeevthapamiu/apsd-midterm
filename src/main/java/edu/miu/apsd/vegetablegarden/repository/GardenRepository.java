package edu.miu.apsd.vegetablegarden.repository;

import edu.miu.apsd.vegetablegarden.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Integer> {

    Optional<Garden> findByName(String name);
}
