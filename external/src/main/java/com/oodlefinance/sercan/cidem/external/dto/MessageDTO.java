package com.oodlefinance.sercan.cidem.external.dto;

/**
 * This class represents a data transfer object (DTO) for a message.
 */
public class MessageDTO {

    private Long id;
    private String message;

    /**
     * Constructor to create a MessageDTO with only text.
     *
     * @param message The text of the message
     */
    public MessageDTO(String message) {
        this.message = message;
    }

    /**
     * Constructor to create a MessageDTO with both id and text.
     *
     * @param id The id of the message
     * @param message The text of the message
     */
    public MessageDTO(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    /**
     * Retrieves the id of the message.
     *
     * @return The id of the message
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the message.
     *
     * @param id The id of the message
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the text of the message.
     *
     * @return The text of the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the text of the message.
     *
     * @param message The text of the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}