package com.interview.scopevisio.Versicherungpraemie;

/**
 * Fahrzeugfaktor is an enum class which maps each vehicle type with a factor
 */
public enum Fahrzeugfaktor {

    PKW(1),
    SUV(2),
    LKW(3);

    private final int wert;
    Fahrzeugfaktor(int wert) {this.wert = wert;}
    public int getWert() {return wert;}

}
