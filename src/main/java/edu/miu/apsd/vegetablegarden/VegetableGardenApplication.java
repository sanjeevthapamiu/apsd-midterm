package edu.miu.apsd.vegetablegarden;

import edu.miu.apsd.vegetablegarden.model.Garden;
import edu.miu.apsd.vegetablegarden.model.Plant;
import edu.miu.apsd.vegetablegarden.repository.GardenRepository;
import edu.miu.apsd.vegetablegarden.service.impl.GardenService;
import edu.miu.apsd.vegetablegarden.service.impl.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class VegetableGardenApplication {

    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(VegetableGardenApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            // Add Data
            Garden garden1 = new Garden("Vegetable Patch", 50.00);
            Garden garden2 = new Garden("Herb Garden", 20.00);

            Plant plant1 = new Plant("Tomato", "Vegetable", LocalDate.of(2024, 3, 10));
            Plant plant2 = new Plant("Carrot", "Vegetable", LocalDate.of(2024, 2, 20));
            Plant plant3 = new Plant("Basil", "Herb", LocalDate.of(2024, 4, 5));

            // Set Plant to Garden
            garden1.addPlant(plant1, plant2);
            garden2.addPlant(plant3);

            gardenService.saveAll(List.of(garden1, garden2));

            System.out.println("Gardens:");
            gardenService.getAllGardens().forEach(System.out::println);

            System.out.println("\nPlants (Sorted by Name):");
            plantService.getAllPlantsSortedByName().forEach(System.out::println);

            System.out.println("\nPlants (Sorted by Plant Date):");
            plantService.getAllPlantsSortedByPlantDate().forEach(System.out::println);
        };
    }

}
