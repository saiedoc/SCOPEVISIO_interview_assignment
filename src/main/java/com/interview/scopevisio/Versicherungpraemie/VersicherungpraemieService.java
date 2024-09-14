package com.interview.scopevisio.Versicherungpraemie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Versicherungpraemie is a service class which contains the methods responsible for the business logic
 * related to the user entries
 */
@Service
public class VersicherungpraemieService {

    @Autowired
    VersicherungpraemieRepository versicherungpraemieRepository;
    @Autowired
    VersicherungpraemieService versicherungpraemieService;

    public VersicherungpraemieService(VersicherungpraemieRepository versicherungpraemieRepository
    ,VersicherungpraemieService versicherungpraemieService) {
        this.versicherungpraemieRepository = versicherungpraemieRepository;
        this.versicherungpraemieService = versicherungpraemieService;
    }

    /**
     * @param versicherungpraemie the user entry which will be stored in the database
     * @return the created object after storing it in the database
     */
    Versicherungpraemie newVersicherungpraemie(Versicherungpraemie versicherungpraemie){
        return versicherungpraemieRepository.save(versicherungpraemie);
    }


}
