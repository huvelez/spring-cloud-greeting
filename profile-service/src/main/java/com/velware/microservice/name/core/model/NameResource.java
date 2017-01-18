package com.velware.microservice.name.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by uriel on 11/6/2016.
 */
public class NameResource extends ResourceSupport {

    private String guid;
    private String content;

    @JsonCreator
    public NameResource(@JsonProperty("content") String content, @JsonProperty("guid") String guid) {
        this.content = content;
        this.guid = guid;
    }

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

    @Override
    public String toString() {
        return "NameResource{" +
                "guid='" + guid + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
