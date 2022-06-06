package com.gfa.websocket.models;

public class OutputMessage {

    // FIELDS
    private String user;
    private String content;

    // CONSTRUCTOR
    public OutputMessage() {
    }

    public OutputMessage(String user, String content) {
        this.user = user;
        this.content = content;
    }

    // GETTERS
    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}
