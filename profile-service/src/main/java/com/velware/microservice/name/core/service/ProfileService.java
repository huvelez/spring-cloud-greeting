package com.velware.microservice.name.core.service;

import com.velware.microservice.name.core.model.ProfileResource;

import java.util.List;

/**
 * Created by uriel on 11/6/2016.
 */
public interface ProfileService {

    public ProfileResource getProfileByName(String name);
}
