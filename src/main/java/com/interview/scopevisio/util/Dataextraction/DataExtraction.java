package com.interview.scopevisio.util.Dataextraction;

import com.interview.scopevisio.Regionalzuordnung.Regionalzuordnung;
import com.interview.scopevisio.Regionalzuordnung.RegionalzuordnungRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

/**
 * DataExtraction is a utility class which contains classes that are used in data extraction
 * from other sources and migrating them to the local database.
 */
@Component
public class DataExtraction {

    @Component
    public static class RegionalzuordnungCSVExtractor {

        private final RegionalzuordnungRepository regionalzuordnungRepository;

        @Autowired
        public RegionalzuordnungCSVExtractor(RegionalzuordnungRepository regionalzuordnungRepository) {
            this.regionalzuordnungRepository = regionalzuordnungRepository;
        }

        // constants for CSV file path and column indices
        public static final String csvFilePath = "postcodes.csv";
        public static final int region1Index = 2;
        public static final int region3Index = 4;
        public static final int region4Index = 5;
        public static final int postleitZahlindex = 6;
        public static final int bezirkIndex = 3;

        // the method to read and save CSV data
        public void extractSaveAll() {
            try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
                String[] nextLine;

                // read each line of the CSV file
                while((nextLine = csvReader.readNext()) != null) {
                    String region1 = nextLine[region1Index];
                    String region3 = nextLine[region3Index];
                    String region4 = nextLine[region4Index];
                    String postleitZahl = nextLine[postleitZahlindex];
                    String bezirk = nextLine[bezirkIndex];

                    // save each entry to the database via repository
                    regionalzuordnungRepository.save(
                            new Regionalzuordnung(region1, region3, region4, postleitZahl, bezirk)
                    );
                }

            } catch (IOException | CsvValidationException e) {
                e.printStackTrace();
            }
        }
    }
}
