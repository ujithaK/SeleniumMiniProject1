package com.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class DataUtils {

    public static Map<String, String> readJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON data");
        }
    }
}
