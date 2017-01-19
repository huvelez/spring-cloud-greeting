package com.velware.microservice.greeter.core.service;

import com.velware.microservice.greeter.core.model.GreetingResource;
import com.velware.microservice.greeter.core.model.GuestGreetingResource;
import com.velware.microservice.greeter.core.model.ProfileResource;

/**
 * Created by uriel on 10/3/2016.
 */
public interface GreeterService {


    public GuestGreetingResource greetGuest(String name);
    public ProfileResource findGuest(String name);
    public ProfileResource noProfileResource(String name);
    public GreetingResource findGreeting(ProfileResource guest);
    public GreetingResource noGreetingResource(ProfileResource guest);
}
