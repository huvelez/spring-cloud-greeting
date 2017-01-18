package com.velware.microservice.greeter.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class GreeterServiceApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GreeterServiceApplication.class);

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jackson2HalModule());

        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);

        RestTemplate restTemplate = builder.build();
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run( GreeterServiceApplication.class, args);
        LOG.info("Application Started[{}] at Port[{}]" ,
                ctx.getEnvironment().getProperty("spring.application.name"),
                ctx.getEnvironment().getProperty("server.port"));
        LOG.info("Connected to RabbitMQ at: [{}]", ctx.getEnvironment().getProperty("spring.rabbitmq.host"));
    }
}
