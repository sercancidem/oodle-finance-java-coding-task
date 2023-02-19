package com.oodlefinance.sercan.cidem.internal.service;

import com.oodlefinance.sercan.cidem.internal.dto.MessageDTO;
import com.oodlefinance.sercan.cidem.internal.exceptions.MessageNotFoundException;
import com.oodlefinance.sercan.cidem.internal.model.Message;
import com.oodlefinance.sercan.cidem.internal.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MessageService provides methods for performing CRUD operations on {@link Message} entities.
 *
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Finds all messages stored in the database and returns them as a list of MessageDTO objects.
     *
     * @return a List of MessageDTO objects
     * @throws MessageNotFoundException if an error occurs while finding all messages
     */
    public List<MessageDTO> findAllMessages() throws MessageNotFoundException {
        try {
            return messageRepository.findAll().stream().map(message -> new MessageDTO(message.getId(), message.getMessage())).toList();
        } catch (Exception e) {
            throw new MessageNotFoundException("Error in finding All Messages", e);
        }
    }

    /**
     * Saves a new message to the database.
     *
     * @param messageDTO a MessageDTO object representing the message to be saved
     * @return a MessageDTO object representing the saved message
     * @throws MessageNotFoundException if an error occurs while saving the message
     */
    public MessageDTO saveMessage(MessageDTO messageDTO) throws MessageNotFoundException {
        try {
            Message message = messageRepository.save(new Message(messageDTO.getMessage()));
            return new MessageDTO(message.getId(), message.getMessage());
        } catch (Exception e) {
            throw new MessageNotFoundException("Error in saving message", e);
        }
    }

    /**
     * Finds a message in the database by its ID.
     *
     * @param id the ID of the message to find
     * @return a MessageDTO object representing the found message
     * @throws MessageNotFoundException if an error occurs while finding the message or if the message with the specified ID does not exist
     */
    public MessageDTO findMessageById(Long id) throws MessageNotFoundException {
        try {
            Message message = messageRepository.findById(id).get();
            return new MessageDTO(message.getId(), message.getMessage());
        } catch (Exception e) {
            throw new MessageNotFoundException("Error finding message by id", e);
        }
    }

    /**
     * Deletes a message from the database by its ID.
     *
     * @param id the ID of the message to delete
     * @throws MessageNotFoundException if an error occurs while deleting the message or if the message with the specified ID does not exist
     */
    public void deleteMessageById(Long id) throws MessageNotFoundException {
        try {
            messageRepository.deleteById(id);
        } catch (Exception e) {
            throw new MessageNotFoundException("Error deleting message by id", e);
        }
    }

}
