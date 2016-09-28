package com.velware.microservice.greeting.core.service;


import com.velware.microservice.greeting.core.model.GreetingResource;

import java.util.List;

public interface GreetingService {

    public List<GreetingResource> getGreetings();
    public List<GreetingResource> emptyGreetings();

}
