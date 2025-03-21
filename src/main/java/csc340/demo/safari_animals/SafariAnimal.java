package csc340.demo.safari_animals;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class SafariAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String diet;

    public SafariAnimal(int animalId, String name, String description, String diet){
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.diet = diet;
    }

    public SafariAnimal(String name, String description, String diet) {
        this.name = name;
        this.description = description;
        this.diet = diet;
    }

    public SafariAnimal(){

    }

    public int getAnimalId() { return animalId;}

    public void setAnimalId(int animalId) {this.animalId = animalId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getDiet() {return diet;}

    public void setDiet(String diet) {this.diet = diet;}






}
