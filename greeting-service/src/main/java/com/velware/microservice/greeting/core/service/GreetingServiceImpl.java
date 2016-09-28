package com.velware.microservice.greeting.core.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.velware.microservice.greeting.core.model.GreetingResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GreetingServiceImpl implements GreetingService{

    private final RestTemplate restTemplate;

    public GreetingServiceImpl(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @Override
    @HystrixCommand(fallbackMethod = "emptyGreetings")
    public List<GreetingResource> getGreetings() {
//        List<GreetingResource> greetings = new ArrayList<>();
//
//        GreetingResource g = new GreetingResource();
//
//        g.setGuid(UUID.randomUUID().toString());
//        g.setContent("Hola");
//        greetings.add(g);
        URI uri = URI.create("http://localhost:8090/recommended");

        ParameterizedTypeReference<List<GreetingResource>> typeRef = new ParameterizedTypeReference<List<GreetingResource>>() {};

        ResponseEntity<List<GreetingResource>> response = restTemplate.exchange("http://example.com", HttpMethod.GET, null, typeRef);

        return response.getBody();

    }

    @Override
    public List<GreetingResource> emptyGreetings() {
        return new ArrayList<>();
    }

}
