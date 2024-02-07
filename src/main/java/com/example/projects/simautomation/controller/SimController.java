package com.example.projects.simautomation.controller;

import com.example.projects.simautomation.service.SimService;
import com.example.projects.simautomation.dto.SimRequestBody;
import com.example.projects.simautomation.dto.SimResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SimController {

    @Autowired
    private SimService service;

    @PostMapping("/deactivate/{vehicleIdentificationNumber}")
    public SimResponseBody deactivateSim(@PathVariable("vehicleIdentificationNumber") String vehicleIdentificationNumber){
       return service.deactivateSimForVehicle(new SimRequestBody(vehicleIdentificationNumber));
    }

    @PostMapping("/activate/{vehicleIdentificationNumber}")
    public SimResponseBody activateSim(@PathVariable("vehicleIdentificationNumber") String vehicleIdentificationNumber){
        return service.activateSimForVehicle(new SimRequestBody(vehicleIdentificationNumber));
    }
}
