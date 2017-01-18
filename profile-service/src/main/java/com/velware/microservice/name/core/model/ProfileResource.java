package com.velware.microservice.name.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by uriel on 11/6/2016.
 */
public class ProfileResource extends ResourceSupport {

    private String guid;
    private String name;
    private ProfileLanguage language;

    @JsonCreator
    public ProfileResource(@JsonProperty("guid") String guid,
                           @JsonProperty("name") String name,
                           @JsonProperty("language") ProfileLanguage language) {
        this.name = name;
        this.guid = guid;
        this.language = language;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileLanguage getLanguage() {
        return language;
    }

    public void setLanguage(ProfileLanguage language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return "ProfileResource{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", language=" + language +
                '}';
    }
}
