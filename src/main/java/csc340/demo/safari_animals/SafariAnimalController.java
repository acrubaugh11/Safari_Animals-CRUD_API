package csc340.demo.safari_animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * REST API endpoint mappings for SafariAnimals object.
 */
@Controller
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
//        return new ResponseEntity<>(service.getAllSafariAnimals(), HttpStatus.OK);
        model.addAttribute("animalList", service.getAllSafariAnimals());
        model.addAttribute("title", "All Safari Animals");
        return "animal-list";
    }

    /**
     * Get safari animal by ID
     * http://localhost:8080/animals/2
     *
     * @param animalId unique animal ID
     * @return one safri animal object
     */
    @GetMapping("/{animalId}")
    public Object getAnimalById(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getSafariAnimalById(animalId));
        model.addAttribute("title", "Safari Animal #: " + animalId);
        return "animal-details";
    }

    /**
     * Fetch all safari animals whose diet meets the restriction
     * http://localhost:8080/animals/diet/carnivore
     *
     * @param diet the diet being filtered to search for
     * @return a list of animals whose diet matches the param 'diet'
     */
    @GetMapping("/diet/{diet}")
    public Object getSafariAnimalsByDiet(@PathVariable String diet, Model model) {
//        return new ResponseEntity<>(service.getSafariAnimalByDiet(diet), HttpStatus.OK);
        model.addAttribute("animalList", service.getSafariAnimalByDiet(diet));
        model.addAttribute("title", "Safari animals by diet :" + diet);
        return "animal-list";
    }

    /**
     * Fetch safari animals by searching for a string
     * http://localhost:8080/animals/name?=zebra
     *
     * @param search the string being searched in safari animals name
     * @return a list of safari animals whose names include string search
     */
    @GetMapping("/name")
    public Object getSafariAnimalsByName(@RequestParam(name = "search", defaultValue = "")String search, Model model){
//        return new ResponseEntity<>(service.getSafariAnimalByName(search), HttpStatus.OK);
        model.addAttribute("animalList", service.getSafariAnimalByName(search));
        model.addAttribute("title", "Safari animals by Name :" + search);
        return "animal-list";

    }


    /**
     * Show the view for a new Safari Animal Form.
     *
     * @param model
     * @return the form view
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        SafariAnimal animal = new SafariAnimal();
        model.addAttribute("animal", animal);
        model.addAttribute("title", "Create New Safari Animal");
        return "animal-create";
    }


    /**
     * Create a new safari animal entry
     * http://localhost:8080/animals/new  --data '{  "name": "sample new safari animal", "description": "large mammal", "diet": carnivore}'
     * @param safariAnimal the new safari animal object
     * @return the updated list of safari animals
     */
    @PostMapping("/new")
    public Object addNewSafariAnimal(SafariAnimal safariAnimal){
        service.addNewSafariAnimal(safariAnimal);
//        return new ResponseEntity<>(service.getAllSafariAnimals(), HttpStatus.OK);
        return "redirect:/animals/all";
    }


    /**
     * Show the update form.
     *
     * @param animalId
     * @param model
     * @return the update form view.
     */
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getSafariAnimalById(animalId));
        model.addAttribute("title", "Update Safari Animal");
        return "animal-update";
    }



    /**
     * Update an existing safari animal object
     * http://localhost:8080/animals/update/2 --data '{  "name": "sample new safari animal", "description": "large mammal", "diet": carnivore}'
     *
     * @param animalId the unique safari animal Id
     * @param safariAnimal the new updated safari animal details
     * @return the new updates safari animals list
     */
    @PostMapping("/update/{animalId}")
    public Object updateSafariAnimal(@PathVariable int animalId, SafariAnimal safariAnimal){
        service.updateSafariAnimal(animalId, safariAnimal);
//        return new ResponseEntity<>(service.getSafariAnimalById(animalId), HttpStatus.OK);
        return "redirect:/animals/" + animalId;
    }


    /**
     * Delete a safari animal object
     * http://localhost:8080/animals/delete/1
     * @param animalId unique safari animal id
     * @return the new list of safari animals after deleting
     */
    @GetMapping("/delete/{animalId}")
    public Object deleteSafariAnimalById(@PathVariable int animalId){
        service.deleteSafariAnimalById(animalId);
//        return new ResponseEntity<>(service.getAllSafariAnimals(), HttpStatus.OK);
        return "redirect:/animals/all";
    }

    /**
     *
     * @return the about page
     */
    @GetMapping("/about")
    public Object getAboutPage(){
        return "about";
    }

}
