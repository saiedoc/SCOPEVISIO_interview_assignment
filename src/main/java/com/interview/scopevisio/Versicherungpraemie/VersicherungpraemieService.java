package com.interview.scopevisio.Versicherungpraemie;


import com.interview.scopevisio.Regionalzuordnung.Regionalzuordnung;
import com.interview.scopevisio.Regionalzuordnung.RegionalzuordnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Versicherungpraemie is a service class which contains the methods responsible for the business logic
 * related to the user entries
 */
@Service
public class VersicherungpraemieService {

    @Autowired
    VersicherungpraemieRepository versicherungpraemieRepository;

    @Autowired
    RegionalzuordnungRepository regionalzuordnungRepository;


    /**
     * bestimmeKilometerlesitungfaktor a method that specifies the value of the mileage factor depending on the mileage value
     * @param kilometerleistung mileage of the vehicle
     * @return the mileage factor depending on the mileage value
     */
    private static double bestimmeKilometerleistungfaktor(int kilometerleistung) {

        if(kilometerleistung >= 0 && kilometerleistung <= 5000) {
            return 0.5;
        } else if (kilometerleistung >= 5001 && kilometerleistung <= 10000)
        {
            return 1.0;
        } else if (kilometerleistung >= 10001 && kilometerleistung <= 20000) {
          return 1.5;
        } else {
            return 2.0;
        }

    }


    public VersicherungpraemieService(VersicherungpraemieRepository versicherungpraemieRepository,
                                      RegionalzuordnungRepository regionalzuordnungRepository) {
        this.versicherungpraemieRepository = versicherungpraemieRepository;
        this.regionalzuordnungRepository = regionalzuordnungRepository;
    }

    /**
     * @param versicherungpraemie the user entry which will be stored in the database
     * @return the created object after storing it in the database
     */
    public Versicherungpraemie newVersicherungpraemie(Versicherungpraemie versicherungpraemie){
        return versicherungpraemieRepository.save(versicherungpraemie);
    }


    /**
     * @param versicherungpraemie user entry which its premium needs to be calculated (using the formel state factor * vehicle type factor * mileage factor)
     * @return insurance premium value
     */
    public double berechneVerischerungspraemine(Versicherungpraemie versicherungpraemie){

        String postleitzahl = versicherungpraemie.getPostleitzahl();
        List<Regionalzuordnung> regionalzuordnungs = regionalzuordnungRepository.findByPostleitzahl(postleitzahl);
        Regionalzuordnung regionalzuordnung = regionalzuordnungRepository.findByPostleitzahl(postleitzahl).getFirst();
        double bundeslandFaktor = Bundeslandfaktor.valueOf(Bundeslandfaktor.getEnglishName(regionalzuordnung.getBundesland()).toUpperCase()).getWert();
        double fahrzeugFaktor = Fahrzeugfaktor.valueOf(versicherungpraemie.getFahrzeugtyp().toUpperCase()).getWert();
        double KilometerleistungFaktor = VersicherungpraemieService.bestimmeKilometerleistungfaktor(versicherungpraemie.getKilometerLeistung());
        return bundeslandFaktor * fahrzeugFaktor *  KilometerleistungFaktor;

    }


}
