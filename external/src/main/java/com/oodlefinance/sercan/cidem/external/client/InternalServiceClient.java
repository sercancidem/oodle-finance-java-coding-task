package com.oodlefinance.sercan.cidem.external.client;

import com.oodlefinance.sercan.cidem.external.dto.MessageDTO;
import com.oodlefinance.sercan.cidem.external.exceptions.MessageNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "internal-service", path = "/api/v1/message")
public interface InternalServiceClient {

  /**
   * Retrieves a list of all messages.
   *
   * @return A list of MessageDTO objects
   * @throws MessageNotFoundException if no messages are found
   */
  @GetMapping("")
  List<MessageDTO> getAllMessages() throws MessageNotFoundException;

  /**
   * Creates a new message.
   *
   * @param messageDTO The MessageDTO object to be saved
   * @return The saved MessageDTO object
   * @throws MessageNotFoundException if the message cannot be saved
   */
  @PostMapping("")
  MessageDTO createMessage(@RequestBody MessageDTO messageDTO) throws MessageNotFoundException;

  /**
   * Retrieves a specific message by its id.
   *
   * @param id The id of the message to retrieve
   * @return The MessageDTO object
   * @throws MessageNotFoundException if the message cannot be found
   */
  @GetMapping("/{id}")
  MessageDTO getMessage(@PathVariable Long id) throws MessageNotFoundException;

  /**
   * Deletes a specific message by its id.
   *
   * @param id The id of the message to delete
   * @throws MessageNotFoundException if the message cannot be found
   */
  @DeleteMapping("/{id}")
  void deleteMessage(@PathVariable Long id) throws MessageNotFoundException ;

}
