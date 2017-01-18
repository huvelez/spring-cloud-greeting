package com.velware.microservice.greeter.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;


public class GreetingResource extends ResourceSupport {

    public GreetingResource() {
    }

    @JsonCreator
    public GreetingResource(@JsonProperty("guid") String guid, @JsonProperty("content") String content, @JsonProperty("language") GreetingLanguage language) {
        this.guid = guid;
        this.content = content;
        this.language = language;
    }

    private String guid;
    private String content;
    private GreetingLanguage language;

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

    public GreetingLanguage getLanguage() {
        return language;
    }

    public void setLanguage(GreetingLanguage language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return "GreetingResource{" +
                "guid='" + guid + '\'' +
                ", content='" + content + '\'' +
                ", language=" + language +
                '}';
    }
}
