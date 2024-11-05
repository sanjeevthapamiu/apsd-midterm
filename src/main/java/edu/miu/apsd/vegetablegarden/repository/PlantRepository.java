package edu.miu.apsd.vegetablegarden.repository;

import edu.miu.apsd.vegetablegarden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    Optional<Plant> findByName(String name);

    List<Plant> findAllByOrderByName();

    List<Plant> findAllByOrderByPlantDate();

}
