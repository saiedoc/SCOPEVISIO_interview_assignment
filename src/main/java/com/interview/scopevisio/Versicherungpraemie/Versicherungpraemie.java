package com.interview.scopevisio.Versicherungpraemie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import javax.annotation.processing.Generated;


/**
 * Versicherungspraemie is an Entity class that represents the entry of the user
 */
@Entity
public class Versicherungpraemie {

    private @Id
    @GeneratedValue Long id;
    private int kilometerLeistung;
    private String postleitzahl;
    private String fahrzeugtyp;
    @Transient
    private double versicherungpraemieWert;

    /**
     * Class constructor
     * @param kilometerLeistung Mileage of the vehicle
     * @param postleitzahl Postcode of the vehicle (Registration Authority)
     * @param fahrzeugtyp Type of the vehicle (PKW, LKW , SUV)
     */
    public Versicherungpraemie(int kilometerLeistung, String postleitzahl, String fahrzeugtyp) {
        this.kilometerLeistung = kilometerLeistung;
        this.postleitzahl = postleitzahl;
        this.fahrzeugtyp = fahrzeugtyp;
    }

    public Versicherungpraemie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKilometerLeistung() {
        return kilometerLeistung;
    }

    public void setKilometerLeistung(int kilometerLeistung) {
        this.kilometerLeistung = kilometerLeistung;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getFahrzeugtyp() {
        return fahrzeugtyp;
    }

    public void setFahrzeugtyp(String fahrzeugtyp) {
        this.fahrzeugtyp = fahrzeugtyp;
    }

    public double getVersicherungpraemieWert() {
        return 5;
    }

    /**
     * @return return the object as a json string
     */
    @Override
    public String toString() {
        return String.format(
                "{\"id\": %d, \"kilometerLeistung\": %d, \"postleitzahl\": \"%s\", \"fahrzeugtyp\": \"%s\" , \"versicherungspraemieWert\": \"%d\"}",
                id, kilometerLeistung, postleitzahl, fahrzeugtyp, this.getVersicherungpraemieWert());

    }

}
