package com.appium.exceptions;

/**
 * This exception is thrown when there is an issue with the capabilities.
 */
public class CapabilityException extends RuntimeException {

    /**
     * Constructs a new CapabilityException with the specified detail message.
     *
     * @param message the detail message.
     */
    public CapabilityException(String message) {
        super(message);
    }
}
