package com.example.projects.simautomation.dto;

public class SimInfo {
    private String simIdentificationNumber;
    private int action;
    private int status;

    public SimInfo(String simIdentificationNumber, int action, int status) {
        this.simIdentificationNumber = simIdentificationNumber;
        this.action = action;
        this.status = status;
    }

    public String getSimIdentificationNumber() {
        return simIdentificationNumber;
    }

    public void setSimIdentificationNumber(String simIdentificationNumber) {
        this.simIdentificationNumber = simIdentificationNumber;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
