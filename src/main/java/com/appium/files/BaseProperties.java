package com.appium.files;

import lombok.experimental.UtilityClass;

/**
 * Utility class for handling base properties.
 */
@UtilityClass
public class BaseProperties {

    /**
     * The name of the property that contains the capabilities file.
     */
    public static final String FILE_FROM_PROPERTY = System.getProperty("capabilities");

}
