package com.velware.microservice.greeting.core.controller;

import com.velware.microservice.greeting.core.model.GreetingResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class GreetingController {


    @RequestMapping(value = "/greetings", method = RequestMethod.GET, produces = "application/json")
    public List<GreetingResource> getGreetingsInJSON() {

        List<GreetingResource> greetings = new ArrayList<>();

        GreetingResource g = new GreetingResource();

        g.setGuid(UUID.randomUUID().toString());
        g.setContent("Hola");
        greetings.add(g);

        return greetings;

    }



}
