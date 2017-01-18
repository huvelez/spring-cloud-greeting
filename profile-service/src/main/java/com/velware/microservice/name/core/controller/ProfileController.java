package com.velware.microservice.name.core.controller;

import com.velware.microservice.name.core.model.ProfileResource;
import com.velware.microservice.name.core.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by uriel on 11/6/2016.
 */
@RestController
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }


    @RequestMapping(value = "/profiles", method = RequestMethod.GET, produces = "application/json")
    public ProfileResource getProfileResourceInJSON(@RequestParam(value = "name") String name) {

        return profileService.getProfileByName(name);

    }

}
