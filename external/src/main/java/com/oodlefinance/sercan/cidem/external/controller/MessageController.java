package com.oodlefinance.sercan.cidem.external.controller;

import com.oodlefinance.sercan.cidem.external.client.InternalServiceClient;
import com.oodlefinance.sercan.cidem.external.dto.MessageDTO;
import com.oodlefinance.sercan.cidem.external.exceptions.MessageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the REST controller for message related operations.
 */
@RestController
@RequestMapping(value="/api/v1/message")
public class MessageController {

    @Autowired
    private InternalServiceClient internalServiceClient;

    /**
     * Retrieves a list of all messages.
     *
     * @return A list of MessageDTO objects
     * @throws MessageNotFoundException if no messages are found
     */
    @GetMapping("")
    public List<MessageDTO> getAllMessages() throws MessageNotFoundException {
        return internalServiceClient.getAllMessages();
    }

    /**
     * Creates a new message.
     *
     * @param messageDTO The MessageDTO object to be saved
     * @return The saved MessageDTO object
     * @throws MessageNotFoundException if the message cannot be saved
     */
    @PostMapping("")
    public MessageDTO createMessage(@RequestBody MessageDTO messageDTO) throws MessageNotFoundException {
        return internalServiceClient.createMessage(messageDTO);
    }

    /**
     * Retrieves a specific message by its id.
     *
     * @param id The id of the message to retrieve
     * @return The MessageDTO objecte
     * @throws MessageNotFoundException if the message cannot be found
     */
    @GetMapping("/{id}")
    public MessageDTO getMessage(@PathVariable Long id) throws MessageNotFoundException {
        return internalServiceClient.getMessage(id);
    }

    /**
     * Deletes a specific message by its id.
     *
     * @param id The id of the message to delete
     * @throws MessageNotFoundException if the message cannot be found
     */
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) throws MessageNotFoundException {
        internalServiceClient.deleteMessage(id);
    }

}