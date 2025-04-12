package csc340.demo.safari_animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SafariAnimalsService.java
 * Centralizes data access to the safarianimals database
 */
@Service
public class SafariAnimalService {

    @Autowired
    private SafariAnimalRepository safariAnimalRepository;

    /**
     *  Fetch all safari animals
     * @return the list of all safari animals
     */
    public List<SafariAnimal> getAllSafariAnimals() {
        return safariAnimalRepository.findAll();
    }

    /**
     * Fetch unique safari animal
     * @param animalId the unique safari animal id
     * @return a unique safari animal
     */
    public SafariAnimal getSafariAnimalById(int animalId) {
        return safariAnimalRepository.findById(animalId).orElse(null);
    }


    /**
     * Add new safari animal to the database
     * @param safariAnimal the new animal being added
     */
    public void addNewSafariAnimal(SafariAnimal safariAnimal) {
        safariAnimalRepository.save(safariAnimal);
    }

    /**
     * Update existing safari animal
     * @param animalId the unique animal id
     * @param safariAnimal the new safari animal details
     */
    public void updateSafariAnimal(int animalId, SafariAnimal safariAnimal) {
        SafariAnimal existing = getSafariAnimalById(animalId);
        existing.setName(safariAnimal.getName());
        existing.setDescription(safariAnimal.getDescription());
        existing.setDiet(safariAnimal.getDiet());

        safariAnimalRepository.save(existing);
    }

    /**
     * Delete a unique safari animal
     * @param animalId the unique animal id
     */
    public void deleteSafariAnimalById(int animalId) {
        safariAnimalRepository.deleteById(animalId);
    }

    /**
     * Fetch all safari animals that match the diet
     * @param diet the diet category of safari animals being searched
     * @return a list of safari animals with specified diet
     */
    public List<SafariAnimal> getSafariAnimalByDiet(String diet){
        return safariAnimalRepository.getSafariAnimalsByDiet(diet);
    }

    /**
     * Fetch safari animals whose name matches a string
     * @param name is the string that is being checked against the safari animals name
     * @return a list of safar animals whose names include string 'name'
     */
    public List<SafariAnimal> getSafariAnimalByName(String name) {
        return safariAnimalRepository.getSafariAnimalsByName(name);
    }









}
