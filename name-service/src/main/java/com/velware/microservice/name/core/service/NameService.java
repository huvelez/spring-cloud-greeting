package com.velware.microservice.name.core.service;

import com.velware.microservice.name.core.model.NameResource;

import java.util.List;

/**
 * Created by uriel on 11/6/2016.
 */
public interface NameService {

    public List<NameResource> getNames();
    public List<NameResource> emptyNames();

}
