package com.example.projects.simautomation.service;

import com.example.projects.simautomation.repository.SimRepository;
import com.example.projects.simautomation.dto.SimVehicleMapping;
import com.example.projects.simautomation.dto.*;
import com.example.projects.simautomation.webClient.SimProviderService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class SimService {

    @Autowired
    private SimRepository simRepository;

    @Autowired
    private SimProviderService simProviderService;

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public SimResponseBody deactivateSimForVehicle(SimRequestBody request) {

        try {
            // Retrieve SIM number from database based on the provided vehicle number
            SimVehicleMapping mapping = simRepository.findByVehicleNumber(request.getVehicleNumber());

            if (mapping == null) {
                throw new NotFoundException("No SIM associated with the provided vehicle number");
            }

            String simIdentificationNumber = mapping.getSimNumber();

            try {
                // Call external API to deactivate SIM
                HttpResponse response = simProviderService.deactivateSIM(new HttpRequest(simIdentificationNumber));

                simRepository.save(new SimInfo(simIdentificationNumber, 0, 1));
                return new SimResponseBody(response.getMessage());
            }
            catch(Exception e){
                simRepository.save(new SimInfo(simIdentificationNumber, 0, 0));
                return new SimResponseBody("Failed");
            }

        }
        catch(NotFoundException e){
            return new SimResponseBody(e.getMessage());
        }
    }

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public SimResponseBody activateSimForVehicle(SimRequestBody request) {

        try {
            // Retrieve SIM number from database based on the provided vehicle number
            SimVehicleMapping mapping = simRepository.findByVehicleNumber(request.getVehicleNumber());

            if (mapping == null) {
                throw new NotFoundException("No SIM associated with the provided vehicle number");
            }

            String simIdentificationNumber = mapping.getSimNumber();

            try {
                // Call external API to deactivate SIM
                HttpResponse response = simProviderService.activateSIM(new HttpRequest(simIdentificationNumber));

                simRepository.save(new SimInfo(simIdentificationNumber, 1, 1));
                return new SimResponseBody(response.getMessage());
            }
            catch(Exception e){
                simRepository.save(new SimInfo(simIdentificationNumber, 1, 2));
                return new SimResponseBody("Failed");
            }

        }
        catch(NotFoundException e){
            return new SimResponseBody(e.getMessage());
        }
    }
}