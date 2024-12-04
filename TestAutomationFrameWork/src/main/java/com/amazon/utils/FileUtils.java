package com.amazon.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;


public class FileUtils {

    // Method to read user credentials from a relative path in the resources folder
    public static UserCredentials readUserCredentialsFromJson(String fileName) throws URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserCredentials userCredentials = null;
        
        try {
            // Get the file from the resources folder (relative path)
            ClassLoader classLoader = FileUtils.class.getClassLoader();
            URL resource = classLoader.getResource(fileName);
            
            if (resource == null) {
                throw new IllegalArgumentException("File not found: " + fileName);
            }
            
            // Convert the URL to a File object
            File file = new File(resource.toURI());
            
            // Read the file and map it to the UserCredentials class
            userCredentials = objectMapper.readValue(file, UserCredentials.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userCredentials;
    }
}
