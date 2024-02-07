package com.example.projects.simautomation.dto;

public class SimRequestBody {
    String vehicleNumber;

    public SimRequestBody(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
