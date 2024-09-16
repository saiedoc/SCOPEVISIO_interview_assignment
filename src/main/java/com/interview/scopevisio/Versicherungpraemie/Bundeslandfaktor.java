package com.interview.scopevisio.Versicherungpraemie;


import java.util.HashMap;
import java.util.Map;

/**
 * Bundeslandfaktor is an enum class which maps each state with a factor
 */
public enum Bundeslandfaktor {

    BADEN_WUERTTEMBERG(1),
    BAYERN(2),
    BERLIN(3),
    BRANDENBURG(1),
    BREMEN(2),
    HAMBURG(3),
    HESSEN(1),
    MECKLENBURG_VORPOMMERN(2),
    NIEDERSACHSEN(3),
    NORDRHEIN_WESTFALEN(1),
    RHEINLAND_PFALZ(2),
    SAARLAND(3),
    SACHSEN(1),
    SACHSEN_ANHALT(2),
    SCHLESWIG_HOLSTEIN(3),
    THUERINGEN(1);

    private final int wert;


    // this map is necessary to handle the difference between german state names in english and german alphabets
    private static final Map<String, String> germanToEnglishMap = new HashMap<>();

    static {
        germanToEnglishMap.put("Baden-Württemberg", "Baden_Wuerttemberg");
        germanToEnglishMap.put("Bayern", "Bayern");
        germanToEnglishMap.put("Berlin", "Berlin");
        germanToEnglishMap.put("Brandenburg", "Brandenburg");
        germanToEnglishMap.put("Bremen", "Bremen");
        germanToEnglishMap.put("Hamburg", "Hamburg");
        germanToEnglishMap.put("Hessen", "Hessen");
        germanToEnglishMap.put("Mecklenburg-Vorpommern", "Mecklenburg-Vorpommern");
        germanToEnglishMap.put("Niedersachsen", "Niedersachsen");
        germanToEnglishMap.put("Nordrhein-Westfalen", "Nortdrhein-Westfalen");
        germanToEnglishMap.put("Rheinland-Pfalz", "Rhineland-Pfalz");
        germanToEnglishMap.put("Saarland", "Saarland");
        germanToEnglishMap.put("Sachsen", "Sachsen");
        germanToEnglishMap.put("Sachsen-Anhalt", "Sachsen-Anhalt");
        germanToEnglishMap.put("Schleswig-Holstein", "Schleswig-Holstein");
        germanToEnglishMap.put("Thüringen", "Thueringen");
    }

    Bundeslandfaktor(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }

    public static String getEnglishName(String germanName) {
        return germanToEnglishMap.get(germanName);
    }
}
