package com.velware.microservice.greeting.core.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.velware.microservice.greeting.core.model.GreetingLanguage;
import com.velware.microservice.greeting.core.model.GreetingResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GreetingServiceImpl implements GreetingService{


    private List<GreetingResource> greetingResources = new ArrayList<>();

    @PostConstruct
    public void init(){
        String uuidHola = UUID.randomUUID().toString();
        String contentHola = "Hola";
        GreetingLanguage languageHola = GreetingLanguage.SPANISH;
        GreetingResource greetingHola = new GreetingResource(uuidHola,contentHola,languageHola);
        this.greetingResources.add(greetingHola);

        String uuidHello = UUID.randomUUID().toString();
        String contentHello = "Hello";
        GreetingLanguage languageHello = GreetingLanguage.ENGLISH;
        GreetingResource greetingHello = new GreetingResource(uuidHello,contentHello,languageHello);
        this.greetingResources.add(greetingHello);
    }

    @Override
    @HystrixCommand
    public GreetingResource findGreetingByLanguage(GreetingLanguage language) {

        for (GreetingResource greetingResource : greetingResources) {
            if(greetingResource.getLanguage().equals(language)){
                return greetingResource;
            }
        }
        return null;
    }


}
