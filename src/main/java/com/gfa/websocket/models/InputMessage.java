package com.gfa.websocket.models;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class InputMessage {

    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long messageId;

    @Column(name = "username")
    private String username;

    @Column(name = "body")
    private String body;

    // CONSTRUCTOR
    public InputMessage() {
    }

    public InputMessage(String body) {
        this.body = body;
    }

    // GETTERS
    public Long getMessageId() {
        return messageId;
    }

    public String getUsername() {
        return username;
    }

    public String getBody() {
        return body;
    }

    // SETTERS
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
