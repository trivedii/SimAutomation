package com.example.projects.simautomation.webClient;

import com.example.projects.simautomation.dto.HttpRequest;
import com.example.projects.simautomation.dto.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimProviderService {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://api.jio.com";

    public SimProviderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HttpResponse deactivateSIM(HttpRequest request) {
        String url = BASE_URL + "/deactivate/" + request.getSimIdentificationNumber();
        return restTemplate.getForObject(url, HttpResponse.class);
    }
    public HttpResponse activateSIM(HttpRequest request) {
        String url = BASE_URL + "/activate/" + request.getSimIdentificationNumber();
        return restTemplate.getForObject(url, HttpResponse.class);
    }
}
