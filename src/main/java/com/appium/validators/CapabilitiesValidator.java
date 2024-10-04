package com.appium.validators;

import com.appium.exceptions.CapabilityException;
import com.appium.extensions.StringExtension;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Utility class for validating capabilities.
 */
@UtilityClass
public class CapabilitiesValidator {

    /**
     * Validates the provided capabilities.
     *
     * @param capabilities the DesiredCapabilities object to validate.
     * @throws CapabilityException if required capabilities are missing.
     */
    public void validateCapabilities(DesiredCapabilities capabilities) {
        if (capabilities.getPlatformName() == null) {
            throw new CapabilityException("platformName capability is required!");
        }

        if (validateAutomateNameCapability(capabilities)) {
            throw new CapabilityException("automationName capability is required!");
        }
    }

    /**
     * Checks if the automationName capability is present.
     *
     * @param capabilities the DesiredCapabilities object to check.
     * @return true if the automationName capability is missing, false otherwise.
     */
    private boolean validateAutomateNameCapability(DesiredCapabilities capabilities) {
        return capabilities.getCapability("appium:automationName") == null &&
                !StringExtension.stringToMap(capabilities.getCapability("appium:options").toString()).containsKey("automationName");
    }
}
