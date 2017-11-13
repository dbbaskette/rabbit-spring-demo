package io.pivotal.bluebunny;


public class ProduceResponse {

    public String getMessage() {
        return message;
    }

    private String message;

    public ProduceResponse(String message) {
        this.message = message;
    }
}
