package com.appium.extensions;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for string operations.
 */
@UtilityClass
public class StringExtension {

    /**
     * Converts a string representation of a map to a Map object.
     *
     * @param str the string representation of the map.
     * @return a Map object containing the parsed key-value pairs.
     */
    public static Map<String, Object> stringToMap(String str) {
        Map<String, Object> map = new HashMap<>();

        String[] pairs = str.trim().replace("{", "")
                .replace("}", "")
                .split(",");

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            map.put(keyValue[0], keyValue[1]);
        }

        return map;
    }

}
