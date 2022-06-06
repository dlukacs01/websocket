package com.gfa.websocket.repositories;

import com.gfa.websocket.models.InputMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<InputMessage, Long> {
}
