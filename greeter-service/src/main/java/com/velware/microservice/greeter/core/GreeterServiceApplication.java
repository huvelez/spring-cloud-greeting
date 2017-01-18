package com.velware.microservice.greeter.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class GreeterServiceApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GreeterServiceApplication.class);

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run( GreeterServiceApplication.class, args);
        LOG.info("Application Started[{}] at Port[{}]" ,
                ctx.getEnvironment().getProperty("spring.application.name"),
                ctx.getEnvironment().getProperty("server.port"));
        LOG.info("Connected to RabbitMQ at: [{}]", ctx.getEnvironment().getProperty("spring.rabbitmq.host"));
    }
}
