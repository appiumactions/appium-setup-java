package com.appium.files;

import static com.appium.files.BaseProperties.FILE_FROM_PROPERTY;

/**
 * This class is responsible for managing the YAML file used for capabilities.
 */
public class YamlFile {

    private static final String DEFAULT_CAPABILITIES_FILE = "capabilities.yml";

    /**
     * Gets the capabilities file name.
     * If the system property "capabilities" is set and not empty, it returns that value.
     * Otherwise, it returns the default capabilities file name.
     *
     * @return the capabilities file name.
     */
    public String getCapabilitiesFile() {
        if (FILE_FROM_PROPERTY != null && !FILE_FROM_PROPERTY.isEmpty()) {
            return FILE_FROM_PROPERTY;
        }

        return DEFAULT_CAPABILITIES_FILE;
    }
}
