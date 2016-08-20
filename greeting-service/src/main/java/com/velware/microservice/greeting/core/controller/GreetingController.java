package com.velware.microservice.greeting.core.controller;

import com.velware.microservice.greeting.core.model.GreetingResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class GreetingController {

    @RequestMapping("/greetings")
    public HttpEntity<GreetingResource> greetings() {

        GreetingResource greeting = new GreetingResource("Hola");
        greeting.add(linkTo(methodOn(GreetingController.class).greetings()).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }



}
