package csc340.demo.safari_animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * REST API endpoint mappings for SafariAnimals object.
 */
@RestController
@RequestMapping("/animals")
public class SafariAnimalController {

    @Autowired
    private SafariAnimalService service;

    /**
     * Get a list of all safari animals in database
     * http://localhost:8080/animals/all
     *
     * @return a list of safari animals objects
     */
    @GetMapping("/all")
    public Object getAllSafariAnimals(Model model) {
        return new ResponseEntity<>(service.getAllSafariAnimals(), HttpStatus.OK);
    }

    /**
     * Get safari animal by ID
     * http://localhost:8080/animals/2
     *
     * @param animalId unique animal ID
     * @return one safri animal object
     */
    @GetMapping("/{animalId}")
    public Object getOneSafariAnimal(@PathVariable int animalId) {
        return new ResponseEntity<>(service.getSafariAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Fetch all safari animals whose diet meets the restriction
     * http://localhost:8080/animals/diet/carnivore
     *
     * @param diet the diet being filtered to search for
     * @return a list of animals whose diet matches the param 'diet'
     */
    @GetMapping("/diet/{diet}")
    public Object getSafariAnimalsByDiet(@PathVariable String diet) {
        return new ResponseEntity<>(service.getSafariAnimalByDiet(diet), HttpStatus.OK);
    }

    /**
     * Fetch safari animals by searching for a string
     * http://localhost:8080/animals/name?=zebra
     *
     * @param search the string being searched in safari animals name
     * @return a list of safari animals whose names include string search
     */
    @GetMapping("/name")
    public Object getSafariAnimalsByName(@RequestParam(name = "search", defaultValue = "")String search){
        return new ResponseEntity<>(service.getSafariAnimalByName(search), HttpStatus.OK);
    }

    /**
     * Create a new safari animal entry
     * http://localhost:8080/animals/new  --data '{  "name": "sample new safari animal", "description": "large mammal", "diet": carnivore}'
     * @param safariAnimal the new safari animal object
     * @return the updated list of safari animals
     */
    @PostMapping("/new")
    public Object addNewSafariAnimal(@RequestBody SafariAnimal safariAnimal){
        service.addNewSafariAnimal(safariAnimal);
        return new ResponseEntity<>(service.getAllSafariAnimals(), HttpStatus.OK);
    }

    /**
     * Update an existing safari animal object
     * http://localhost:8080/animals/update/2 --data '{  "name": "sample new safari animal", "description": "large mammal", "diet": carnivore}'
     *
     * @param animalId the unique safari animal Id
     * @param safariAnimal the new updated safari animal details
     * @return the new updates safari animals list
     */
    @PutMapping("/update/{animalId}")
    public Object updateSafariAnimal(@PathVariable int animalId, @RequestBody SafariAnimal safariAnimal){
        service.updateSafariAnimal(animalId, safariAnimal);
        return new ResponseEntity<>(service.getSafariAnimalById(animalId), HttpStatus.OK);
    }


    /**
     * Delete a safari animal object
     * http://localhost:8080/animals/delete/1
     * @param animalId unique safari animal id
     * @return the new list of safari animals after deleting
     */
    @DeleteMapping("/delete/{animalId}")
    public Object deleteSafariAnimalById(@PathVariable int animalId){
        service.deleteSafariAnimalById(animalId);
        return new ResponseEntity<>(service.getAllSafariAnimals(), HttpStatus.OK);
    }

}
