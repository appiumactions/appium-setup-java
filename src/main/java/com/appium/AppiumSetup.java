package com.appium;

import com.appium.converters.YamlConverter;
import com.appium.files.YamlFile;
import com.appium.validators.CapabilitiesValidator;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class is responsible for setting up Appium capabilities.
 */
public class AppiumSetup {

    /**
     * Loads the capabilities from a default YAML file.
     * The default file must be called capabilities.yml and must be in the path src/main/resources
     *
     * @return DesiredCapabilities object containing the loaded capabilities.
     */
    public DesiredCapabilities loadCapabilities() {
        String capabilitiesFile = new YamlFile().getCapabilitiesFile();
        DesiredCapabilities capabilities = new YamlConverter().yamlToDesiredCapabilities(capabilitiesFile);

        CapabilitiesValidator.validateCapabilities(capabilities);

        return capabilities;
    }

    /**
     * Loads the capabilities from a specified YAML file.
     *
     * @param capabilitiesFile the name to the YAML file containing the capabilities. The file must be in the path src/main/resources
     * @return DesiredCapabilities object containing the loaded capabilities.
     */
    public DesiredCapabilities loadCapabilities(String capabilitiesFile) {
        DesiredCapabilities capabilities = new YamlConverter().yamlToDesiredCapabilities(capabilitiesFile);

        CapabilitiesValidator.validateCapabilities(capabilities);

        return capabilities;
    }
}
