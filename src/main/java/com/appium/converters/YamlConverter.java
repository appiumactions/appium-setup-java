package com.appium.converters;

import com.appium.exceptions.YamlException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * This class is responsible for converting YAML files to DesiredCapabilities objects.
 */
public class YamlConverter {

    /**
     * Converts a YAML file to a DesiredCapabilities object.
     *
     * @param capabilitiesFile the name to the YAML file containing the capabilities.
     * @return DesiredCapabilities object containing the loaded capabilities.
     * @throws YamlException if the file cannot be parsed.
     */
    public DesiredCapabilities yamlToDesiredCapabilities(String capabilitiesFile) {
        Yaml yaml = new Yaml();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        validateIfFileExists(capabilitiesFile);

        try (InputStream inputStream = YamlConverter.class.getClassLoader().getResourceAsStream(capabilitiesFile)) {
            Map<String, Object> data = yaml.load(inputStream);

            for (Map.Entry<String, Object> entry : data.entrySet()) {
                capabilities.setCapability(entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            throw new YamlException("Failed to parse capabilities", e);
        }

        return capabilities;
    }


    /**
     * Validates if the specified file exists in the resources directory.
     *
     * @param capabilitiesFile the path to the YAML file.
     * @throws YamlException if the file does not exist.
     */
    private void validateIfFileExists(String capabilitiesFile) {
        Path path = Paths.get("src/main/resources/" + capabilitiesFile);

        if (!Files.exists(path)) {
            throw new YamlException("File not found in path: src/main/resources/" + capabilitiesFile);
        }
    }
}
