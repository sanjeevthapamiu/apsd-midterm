package edu.miu.apsd.vegetablegarden;

import edu.miu.apsd.vegetablegarden.model.Garden;
import edu.miu.apsd.vegetablegarden.model.Plant;
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
            Garden vegetablePatch = new Garden("Vegetable Patch", 50.00);
            Garden herbGarden = new Garden("Herb Garden", 20.00);

            Plant plant1 = new Plant("Tomato", "Vegetable", LocalDate.of(2024, 3, 10), vegetablePatch);
            Plant plant2 = new Plant("Carrot", "Vegetable", LocalDate.of(2024, 2, 20), vegetablePatch);
            Plant plant3 = new Plant("Basil", "Herb", LocalDate.of(2024, 4, 5), herbGarden);

            // Set Plant to Garden
            vegetablePatch.setPlants(List.of(plant1, plant2));
            herbGarden.setPlants(List.of(plant3));

            // Saves all gardens along with plants, fast
            gardenService.saveAll(List.of(vegetablePatch, herbGarden));


            // Display All Gardens:
            System.out.println("\nGardens:");
            gardenService.getAllGardens().forEach(System.out::println);

            // Display All Plants (Sorted by Name):
            System.out.println("\nPlants (Sorted by Name):");
            plantService.getAllPlantsSortedByName().forEach(System.out::println);

            // Display All Plants (Sorted by Plant Date):
            System.out.println("\nPlants (Sorted by Plant Date):");
            plantService.getAllPlantsSortedByPlantDate().forEach(System.out::println);


            // === Garden CRUD Operation: ===
            System.out.println("\nGarden CRUD Operation: ");

            // Save Flower Garden
            gardenService.save(new Garden("Flower Garden", 45.00));

            // Change Flower Garden size from 45.00 to 65.00
            gardenService.getByName("Flower Garden").ifPresent(garden -> {
                garden.setSize(65.00);
                gardenService.update(garden);
            });

            // Delete
            gardenService.deleteByName("Vegetable Patch");

            gardenService.getAllGardens().forEach(System.out::println);


            // === Plant CRUD Operation: ===
            System.out.println("\nPlant CRUD Operation: ");

            // Add rosemary to herb garden
            plantService.save(new Plant("Rosemary", "Herb Garden", LocalDate.now(), herbGarden));

            // Change Tomato type to Fruit
            plantService.getByName("Tomato").ifPresent(plant -> {
                plant.setType("Fruit");
                plantService.update(plant);
            });

            // Delete Carrot from vegetable patch
            plantService.deleteByName("Carrot");

            plantService.getAllPlants().forEach(System.out::println);
            System.out.println();
        };
    }

}
