package com.velware.microservice.greeter.core.controller;

import com.velware.microservice.greeter.core.model.GuestGreetingResource;
import com.velware.microservice.greeter.core.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uriel on 10/3/2016.
 */
@RestController
public class GreeterController {

    private GreeterService greeterService;

    @Autowired
    public void setGreeterService(GreeterService greeterService) {
        this.greeterService = greeterService;
    }

    @RequestMapping(value = "/greet", produces = "application/hal+json",method = RequestMethod.GET)
    public GuestGreetingResource greetGuest(@RequestParam("name") String name){
        return greeterService.greetGuest(name);
    }
}
