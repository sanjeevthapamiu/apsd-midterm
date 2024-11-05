package edu.miu.apsd.vegetablegarden.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Plant name must not be blank")
    @Column(unique = true, nullable = false)
    private String name;

    private String type;

    @Column(name = "plant_date")
    private LocalDate plantDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "garden_id")
    private Garden garden;

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name:" + name +
                ", Type: " + type +
                ", Plant Date: " + plantDate +
                ", Garden: " + garden.getName();
    }



    public Plant(String name, String type, LocalDate plantDate) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
    }

    public Plant(String name, String type, LocalDate plantDate, Garden garden) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
        this.garden = garden;
    }
}
