package com.example.projects.simautomation.dto;

public class HttpResponse {
    String message;

    public HttpResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
