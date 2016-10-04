package com.velware.microservice.greeter.core.client;

import java.util.List;

/**
 * Created by uriel on 10/3/2016.
 */
public interface GreetingClient {

    List<GreetingResource> getGreetings();

}
