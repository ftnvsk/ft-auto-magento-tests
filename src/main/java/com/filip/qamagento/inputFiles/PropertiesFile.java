package com.filip.qamagento.inputFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesFile {

    // Here I declare a Properties object to hold key-value pairs from the properties file.
    public Properties properties;
    // Here I declare a FileInputStream to read data from the properties file.
    public FileInputStream file;

    public PropertiesFile() {
        loadFile();
    }

    // This is a method to load the properties file.
    public void loadFile() {
        properties = new Properties();
        try {
            // here I initialize the file input stream with the path to the properties file.
            file = new FileInputStream("src/main/java/resources/inputData.properties");
            // Load properties from the file.
            properties.load(file);
        } catch (IOException e) {
            // this a runtime exception if there's an error reading the file.
            throw new RuntimeException(e);
        }
    }

    // Here I have a method to get a value by its key from the loaded properties.
    public String getValue(String key) {
        return properties.getProperty(key);
    }

    // A method to get all key-value pairs from the properties file as a HashMap.
    public HashMap<String, String> getAll() {
        HashMap<String, String> testData = new HashMap<>();
        for(Object key : properties.keySet()) {
            testData.put(key.toString(), properties.getProperty(key.toString()));
        }
        return testData;
    }

}
