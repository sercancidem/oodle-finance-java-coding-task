package com.oodlefinance.sercan.cidem.external.exceptions;

/**
 * This class represents an exception for when a message is not found.
 */
public class MessageNotFoundException extends Exception {

    /**
     * Constructor for creating a MessageNotFoundException without a message or cause.
     */
    public MessageNotFoundException() {
        super();
    }

    /**
     * Constructor for creating a MessageNotFoundException with a message and cause.
     *
     * @param message The message of the exception
     * @param e The cause of the exception
     */
    public MessageNotFoundException(String message, Exception e) {
        super(message, e);
    }
}