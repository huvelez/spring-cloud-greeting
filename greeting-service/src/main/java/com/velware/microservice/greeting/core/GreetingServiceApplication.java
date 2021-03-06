package com.velware.microservice.greeting.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class GreetingServiceApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run( GreetingServiceApplication.class, args);
        LOG.info("Application Started[{}] on Port[{}]" ,
                ctx.getEnvironment().getProperty("spring.application.name"),
                ctx.getEnvironment().getProperty("server.port"));
        LOG.info("Connected to RabbitMQ at: [{}] on Port[{}]",
                ctx.getEnvironment().getProperty("spring.rabbitmq.host"),
                ctx.getEnvironment().getProperty("spring.rabbitmq.port"));
    }
}
