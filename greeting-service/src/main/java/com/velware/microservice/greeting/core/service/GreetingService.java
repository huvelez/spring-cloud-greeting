package com.velware.microservice.greeting.core.service;


import com.velware.microservice.greeting.core.model.GreetingLanguage;
import com.velware.microservice.greeting.core.model.GreetingResource;

import java.util.List;

public interface GreetingService {

    public GreetingResource findGreetingByLanguage(GreetingLanguage language);

}
