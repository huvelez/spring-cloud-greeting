package com.velware.microservice.name.core.service;

import com.velware.microservice.name.core.model.ProfileLanguage;
import com.velware.microservice.name.core.model.ProfileResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by uriel on 11/6/2016.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    private List<ProfileResource> profileResources = new ArrayList<>();

    @PostConstruct
    public void init(){
        String uuidHector = UUID.randomUUID().toString();
        String nameHector = "Hector";
        ProfileLanguage languageHector = ProfileLanguage.SPANISH;
        ProfileResource profileHector = new ProfileResource(uuidHector,nameHector,languageHector);
        this.profileResources.add(profileHector);

        String uuidJohn = UUID.randomUUID().toString();
        String nameJohn = "John";
        ProfileLanguage languageJohn = ProfileLanguage.ENGLISH;
        ProfileResource profileJohn = new ProfileResource(uuidJohn,nameJohn,languageJohn);
        this.profileResources.add(profileJohn);
    }

    @Override
    public ProfileResource getProfileByName(String name) {

        for (ProfileResource profileResource : profileResources) {
            if(profileResource.getName().equalsIgnoreCase(name)){
                return profileResource;
            }
        }
        return null;
    }
}
