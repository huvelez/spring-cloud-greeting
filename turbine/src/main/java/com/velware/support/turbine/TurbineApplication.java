package com.velware.support.turbine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableTurbineStream
@EnableEurekaClient
public class TurbineApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TurbineApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(TurbineApplication.class).run(args);
    }
}
