package com.velware.microservice.name.core.controller;

import com.velware.microservice.name.core.model.NameResource;
import com.velware.microservice.name.core.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by uriel on 11/6/2016.
 */
public class NameController {

    @Autowired
    private NameService nameService;

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }


    @RequestMapping(value = "/greetings", method = RequestMethod.GET, produces = "application/json")
    public List<NameResource> getGreetingsInJSON() {

        return nameService.getNames();

    }

}
