package com.ali.superz.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    public static Map<String, String> loadJsonFromFile(String filePath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Map<String, String> jsonMap = new HashMap<>();
        String line;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while (line != null) {
                int split = line.indexOf(':');
                String key = line.substring(0, split);
                String value = line.substring(split + 1);
                jsonMap.put(key, value);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("Error while reading inputStream: %s", e.getMessage()));
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(String.format("Error while closing FileReader: %s", e.getMessage()));
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            throw new RuntimeException(String.format("Error while closing BufferedReader: %s", e.getMessage()));
                        }
                    }
                }
            }
            return jsonMap;
        }
    }
}
