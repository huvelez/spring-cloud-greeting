package com.velware.support.edge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EdgeServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(EdgeServerApplication.class);

    static {
        // for localhost testing only
        LOG.warn("Will now disable hostname check in SSL, only to be used during development");
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(EdgeServerApplication.class, args);
        LOG.info("Application Started[{}] on Port[{}]" ,
                ctx.getEnvironment().getProperty("spring.application.name"),
                ctx.getEnvironment().getProperty("server.port"));
        LOG.info("Connected to RabbitMQ at: [{}] on Port[{}]",
                ctx.getEnvironment().getProperty("spring.rabbitmq.host"),
                ctx.getEnvironment().getProperty("spring.rabbitmq.port"));
    }
}
