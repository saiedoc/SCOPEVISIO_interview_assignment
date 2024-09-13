package com.interview.scopevisio.Versicherungpraemie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersicherungpraemieController {

    @Autowired
    VersicherungpraemieRepository versicherungpraemieRepository;

    VersicherungpraemieController(VersicherungpraemieRepository versicherungpraemieRepository){
        this.versicherungpraemieRepository = versicherungpraemieRepository;
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
    @PostMapping("/versicherungpraemie")
    Versicherungpraemie newVersicherungpraemie(@RequestBody Versicherungpraemie versicherungpraemie){
        return versicherungpraemieRepository.save(versicherungpraemie);
    }

}
