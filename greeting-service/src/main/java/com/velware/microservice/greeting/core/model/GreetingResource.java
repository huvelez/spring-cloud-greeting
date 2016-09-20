package com.velware.microservice.greeting.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;


public class GreetingResource extends ResourceSupport {

    public GreetingResource() {
    }

    @JsonCreator
    public GreetingResource(@JsonProperty("content") String content, @JsonProperty("guid") String guid) {
        this.content = content;
    }

    private String guid;
    private String content;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
