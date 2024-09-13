package com.interview.scopevisio.util.Dataextraction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * DataExtractionRunner is a runner class which contains extraction methods that should be executed
 * with server start
 */
@Component
public class DataExtractionRunner implements CommandLineRunner {

    private final DataExtraction.RegionalzuordnungCSVExtractor regionalzuordnungCSVExtractor;

    public DataExtractionRunner(DataExtraction.RegionalzuordnungCSVExtractor regionalzuordnungCSVExtractor) {
        this.regionalzuordnungCSVExtractor = regionalzuordnungCSVExtractor;
    }

    @Override
    public void run(String... args) throws Exception {
        regionalzuordnungCSVExtractor.extractSaveAll();
    }
}
