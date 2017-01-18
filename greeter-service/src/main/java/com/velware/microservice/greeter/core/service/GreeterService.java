package com.velware.microservice.greeter.core.service;

import com.velware.microservice.greeter.core.model.GuestGreetingResource;

/**
 * Created by uriel on 10/3/2016.
 */
public interface GreeterService {

    public GuestGreetingResource greetGuest(String name);
}
