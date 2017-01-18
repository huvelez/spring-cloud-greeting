package com.velware.microservice.greeter.core.service;

import com.velware.microservice.greeter.core.model.GuestGreetingResource;
import com.velware.microservice.greeter.core.model.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
//    @LoadBalanced
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GuestGreetingResource greetGuest(String name) {

        String url = "profileservice/profiles?name={name}";

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("name", name);

        ResponseEntity<ProfileResource> responseEntity = restTemplate.getForEntity(builder.toUriString(), ProfileResource.class);

        ProfileResource profileResource = responseEntity.getBody();


        return null;
    }

}
