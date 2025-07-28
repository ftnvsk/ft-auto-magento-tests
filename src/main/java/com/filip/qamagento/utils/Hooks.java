package com.filip.qamagento.utils;

import com.filip.qamagento.inputFiles.PropertiesFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    // The below will run before each Cucumber scenario
    @Before
    public void prepareEnv() {
        String baseURL = new PropertiesFile().getValue("baseURL");
        WebDriverInstance.createDriver(baseURL);
    }

    // The below will run after each Cucumber scenario
    @After
    public void clearEnv(Scenario scenario) {
        WebDriverInstance.cleanUpDriver(scenario);
    }

}