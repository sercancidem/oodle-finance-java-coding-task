package com.oodlefinance.sercan.cidem.internal.repository;

import com.oodlefinance.sercan.cidem.internal.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Message} entities.
 *
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}