package com.velware.microservice.greeting.core.controller;

import com.velware.microservice.greeting.core.model.GreetingLanguage;
import com.velware.microservice.greeting.core.model.GreetingResource;
import com.velware.microservice.greeting.core.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GreetingController {

    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping(value = "/greetings", method = RequestMethod.GET, produces = "application/hal+json")
    public GreetingResource getGreetingsInJSON(@RequestParam("language") GreetingLanguage language) {

        return greetingService.findGreetingByLanguage(language);

    }

}
