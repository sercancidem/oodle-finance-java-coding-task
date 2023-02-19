package com.oodlefinance.sercan.cidem.internal.controller;

import com.oodlefinance.sercan.cidem.internal.dto.MessageDTO;
import com.oodlefinance.sercan.cidem.internal.exceptions.MessageNotFoundException;
import com.oodlefinance.sercan.cidem.internal.service.MessageService;
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
    private MessageService messageService;

    /**
     * Retrieves a list of all messages.
     *
     * @return A list of MessageDTO objects
     * @throws MessageNotFoundException if no messages are found
     */
    @GetMapping("")
    public List<MessageDTO> getAllMessages() throws MessageNotFoundException {
        return messageService.findAllMessages();
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
        return messageService.saveMessage(messageDTO);
    }

    /**
     * Retrieves a specific message by its id.
     *
     * @param id The id of the message to retrieve
     * @return The MessageDTO object
     * @throws MessageNotFoundException if the message cannot be found
     */
    @GetMapping("/{id}")
    public MessageDTO getMessage(@PathVariable Long id) throws MessageNotFoundException {
        return messageService.findMessageById(id);
    }

    /**
     * Deletes a specific message by its id.
     *
     * @param id The id of the message to delete
     * @throws MessageNotFoundException if the message cannot be found
     */
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) throws MessageNotFoundException {
        messageService.deleteMessageById(id);
    }

}