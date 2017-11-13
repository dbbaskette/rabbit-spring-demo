package io.pivotal.bluebunny;

import java.util.List;

public class ConsumerResponse {

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    private List<String> messages;

    public ConsumerResponse(List<String> messages) {
        this.messages = messages;
    }
}
