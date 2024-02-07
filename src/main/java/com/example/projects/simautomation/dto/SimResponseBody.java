package com.example.projects.simautomation.dto;

public class SimResponseBody {
    private String message;

    public SimResponseBody(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
