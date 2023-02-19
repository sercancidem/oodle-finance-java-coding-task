package com.oodlefinance.sercan.cidem.internal.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class represents a message entity.
 */
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String message;

    /**
     * Constructor for creating an empty Message object.
     */
    public Message() {

    }

    /**
     * Constructor for creating a Message object with text.
     *
     * @param message The text of the message
     */
    public Message(String message) {
        this.message = message;
    }

    /**
     * Returns the id of the message.
     *
     * @return The id of the message
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the message.
     *
     * @param id The id to set for the message
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the text of the message.
     *
     * @return The text of the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the text of the message.
     *
     * @param text The text to set for the message
     */
    public void setMessage(String text) {
        this.message = text;
    }

}
