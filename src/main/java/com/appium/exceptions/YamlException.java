package com.appium.exceptions;

/**
 * This exception is thrown when there is an issue with parsing YAML files.
 */
public class YamlException extends RuntimeException {

    /**
     * Constructs a new YamlException with the specified detail message.
     *
     * @param message the detail message.
     */
    public YamlException(String message) {
        super(message);
    }

    /**
     * Constructs a new YamlException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause   the cause of the exception.
     */
    public YamlException(String message, Throwable cause) {
        super(message, cause);
    }
}
