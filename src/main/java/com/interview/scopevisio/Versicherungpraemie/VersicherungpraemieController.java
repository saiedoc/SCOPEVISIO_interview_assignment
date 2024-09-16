package com.interview.scopevisio.Versicherungpraemie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * VersicherungspraemieController is a controller class that contains all endpoints relevant to user
 * insurance premium queries
 */
@RestController
@RequestMapping("/versicherungpraemie")
public class VersicherungpraemieController {

    @Autowired
    VersicherungpraemieService versicherungpraemieService;

    VersicherungpraemieController(VersicherungpraemieService versicherungpraemieService){
        this.versicherungpraemieService = versicherungpraemieService;
    }

    /**
     * REST API POST endpoint to add a new user entry to the database
     * the request body is from the form:
     * {
     * 	"Kilometerleistung" : integer_value,
     * 	"Postleitezahl": string_value,
     * 	"Fahrzeugtyp": string_value
     * }
     * @param versicherungpraemie object of class Versicherungpraemie
     * @return the newly created entry as json string
     */
    @PostMapping("/eintrag-speichern")
    Versicherungpraemie newVersicherungpraemie(@RequestBody Versicherungpraemie versicherungpraemie){
        return versicherungpraemieService.newVersicherungpraemie(versicherungpraemie);
    }


    /**
     * REST API POST endpoint to calculate the insurance premium of an entry
     * the request body is from the form:
     * {
     * 	"Kilometerleistung" : integer_value,
     * 	"Postleitezahl": string_value,
     * 	"Fahrzeugtyp": string_value
     * }
     * @param versicherungpraemie object of class Versicherungpraemie
     * @return the insurance premium value as a json sting from the form
     * {
     *     "versicherungpraemie" : double_value
     * }
     */
    @GetMapping("/berechne-versicherungpraemie")
    public Map<String,Double> berechneVersicherungpraemie(@RequestBody Versicherungpraemie versicherungpraemie){
        return Map.of("versichrungpraemie", versicherungpraemieService.berechneVerischerungspraemine(versicherungpraemie));
    }

}
