package edu.miu.apsd.vegetablegarden.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gardens")
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Garden Name must not be blank")
    @Column(unique = true, nullable = false)
    private String name;

    private Double size;

    @OneToMany(mappedBy = "garden", cascade = CascadeType.ALL)
    private List<Plant> plants;

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Size: " + size + " m^2";
    }



    public Garden(String name, Double size) {
        this.name = name;
        this.size = size;
    }

//    public void addPlant(Plant plant) {
//        plant.setGarden(this);
//        plants.add(plant);
//    }
//
//    public void addPlant(Plant... plants) {
//        Arrays.stream(plants).forEach(this::addPlant);
//    }
}
