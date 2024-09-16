package com.interview.scopevisio.Versicherungpraemie;

import com.interview.scopevisio.Regionalzuordnung.Regionalzuordnung;
import com.interview.scopevisio.Regionalzuordnung.RegionalzuordnungRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VersicherungpraemieServiceTest {

    @InjectMocks
    private VersicherungpraemieService versicherungpraemieService;

    @Mock
    private VersicherungpraemieRepository versicherungpraemieRepository;

    @Mock
    private RegionalzuordnungRepository regionalzuordnungRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void newVersicherungpraemie() {
        Versicherungpraemie input = new Versicherungpraemie();
        input.setPostleitzahl("79189");
        input.setFahrzeugtyp("PKW");
        input.setKilometerLeistung(5000);
        Versicherungpraemie saved = new Versicherungpraemie();
        saved.setPostleitzahl("79189");
        saved.setFahrzeugtyp("PKW");
        input.setKilometerLeistung(5000);
        when(versicherungpraemieRepository.save(input)).thenReturn(saved);
        // call method
        Versicherungpraemie result = versicherungpraemieService.newVersicherungpraemie(input);
        // check if saving is done and the saved object is not null
        assertNotNull(result);
        // check using the postcode that the saved object is same to the sent object
        assertEquals(saved.getPostleitzahl(), result.getPostleitzahl());
        verify(versicherungpraemieRepository).save(input);
    }

    @Test
    void berechneVerischerungspraemine() {
        String postleitzahl = "79189";
        Regionalzuordnung regionalzuordnung = new Regionalzuordnung();
        regionalzuordnung.setBundesland("Baden-Württemberg");

        Versicherungpraemie input = new Versicherungpraemie();
        input.setPostleitzahl("79189");
        input.setFahrzeugtyp("PKW");
        input.setKilometerLeistung(5000);

        // mock repository behavior
        when(regionalzuordnungRepository.findByPostleitzahl(postleitzahl))
                .thenReturn(new ArrayList<Regionalzuordnung>(){{add(regionalzuordnung);}});


        // calculate the expected factor
        double expectedFaktor = 1.0 * 1.0 * 0.5; // bundeslandFaktor * fahrzeugFaktor * KilometerleistungFaktor

        // perform the calculation
        double result = versicherungpraemieService.berechneVerischerungspraemine(input);

        // verify the result
        assertEquals(expectedFaktor, result);
    }

}