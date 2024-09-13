package com.interview.scopevisio.Regionalzuordnung;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


/**
 * Regionalzuordnung is an entity class that represents the regional assignment entry which contains relevant information for the insurance
 */
@Entity
public class Regionalzuordnung {

    private @Id
    @GeneratedValue Long id;
    private String bundesland;
    private String land;
    private String ort;
    private String postleitzahl;
    private String bezirk;

    /**
     * Class constructor
     * @param bundesland represents the state
     * @param land represents the country
     * @param ort represents the city
     * @param postleitzahl represents the postcode
     * @param bezirk represents the district
     */
    public Regionalzuordnung(String bundesland, String land, String ort, String postleitzahl, String bezirk) {
        this.bundesland = bundesland;
        this.land = land;
        this.ort = ort;
        this.postleitzahl = postleitzahl;
        this.bezirk = bezirk;
    }

    public Regionalzuordnung() {

    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getBezirk() {
        return bezirk;
    }

    public void setBezirk(String bezirk) {
        this.bezirk = bezirk;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"bundesland\": \"%s\", \"land\": \"%s\", \"ort\": \"%s\", \"postleitzahl\": \"%s\", \"bezirk\": \"%s\", \"id\": %d}",
                bundesland, land, ort, postleitzahl, bezirk, id
        );
    }

}
