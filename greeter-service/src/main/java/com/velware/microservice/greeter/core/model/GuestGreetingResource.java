package com.velware.microservice.greeter.core.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by uriel on 10/3/2016.
 */
public class GuestGreetingResource extends ResourceSupport {

    private String guestName;
    private String guestGreeting;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestGreeting() {
        return guestGreeting;
    }

    public void setGuestGreeting(String guestGreeting) {
        this.guestGreeting = guestGreeting;
    }

    public GuestGreetingResource(String guestName, String guestGreeting) {
        this.guestName = guestName;
        this.guestGreeting = guestGreeting;
    }

    @Override
    public String toString() {
        return "GuestGreetingResource{" +
                "guestName='" + guestName + '\'' +
                ", guestGreeting='" + guestGreeting + '\'' +
                '}';
    }
}
