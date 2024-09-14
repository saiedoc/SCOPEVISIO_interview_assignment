package com.interview.scopevisio.Versicherungpraemie;

public enum Bundeslandfaktor {

    BADEN_WUERTTEMBERG(1, "Baden-Württemberg"),
    BAYERN(2, "Bayern"),
    BERLIN(3, "Berlin"),
    BRANDENBURG(1, "Brandenburg"),
    BREMEN(2, "Bremen"),
    HAMBURG(3, "Hamburg"),
    HESSEN(1, "Hessen"),
    MECKLENBURG_VORPOMMERN(2, "Mecklenburg-Vorpommern"),
    NIEDERSACHSEN(3, "Niedersachsen"),
    NORDRHEIN_WESTFALEN(1, "Nordrhein-Westfalen"),
    RHEINLAND_PFALZ(2, "Rheinland-Pfalz"),
    SAARLAND(3, "Saarland"),
    SACHSEN(1, "Sachsen"),
    SACHSEN_ANHALT(2, "Sachsen-Anhalt"),
    SCHLESWIG_HOLSTEIN(3, "Schleswig-Holstein"),
    THUERINGEN(1, "Thüringen");

    private final int wert;
    private final String deutscherName;

    Bundeslandfaktor(int wert, String deutscherName) {
        this.wert = wert;
        this.deutscherName = deutscherName;
    }

    public int getWert() {
        return wert;
    }

    public String getDeutscherName() {
        return deutscherName;
    }

}
