package com.velware.microservice.greeting.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;


public class GreetingResource extends ResourceSupport {

    private final String content;

    @JsonCreator
    public GreetingResource(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
