package com.velware.microservice.greeter.core.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.velware.microservice.greeter.core.model.GreetingResource;
import com.velware.microservice.greeter.core.model.GuestGreetingResource;
import com.velware.microservice.greeter.core.model.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by uriel on 10/3/2016.
 */
@Service
public class GreeterServiceImpl implements GreeterService {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GuestGreetingResource greetGuest(String name) {

        ProfileResource guest = this.findGuest(name);
        GreetingResource greeting = this.findGreeting(guest.getLanguage().name());
        return new GuestGreetingResource(guest.getName(),greeting.getContent());
    }

    @HystrixCommand
    private ProfileResource findGuest(String name) {
        String url = "http://profileservice/profiles";

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("name", name);

        ResponseEntity<ProfileResource> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,null,ProfileResource.class);

        return responseEntity.getBody();
    }

    @HystrixCommand
    private GreetingResource findGreeting(String language) {
        String url = "http://greetingservice/greetings";

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("language", language);

        ResponseEntity<GreetingResource> responseEntity = restTemplate.getForEntity(builder.toUriString(), GreetingResource.class);

        return responseEntity.getBody();
    }

}
