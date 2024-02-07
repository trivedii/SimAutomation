package com.example.projects.simautomation.dto;

public class HttpRequest {
    String simIdentificationNumber;

    public HttpRequest(String simIdentificationNumber) {
        this.simIdentificationNumber = simIdentificationNumber;
    }

    public String getSimIdentificationNumber() {
        return simIdentificationNumber;
    }

    public void setSimIdentificationNumber(String simIdentificationNumber) {
        this.simIdentificationNumber = simIdentificationNumber;
    }
}
