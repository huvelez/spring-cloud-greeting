package com.velware.support.config.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigServerApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ConfigServerApplication.class, args);
        LOG.info("Application Started[{}] on Port[{}]" ,
                ctx.getEnvironment().getProperty("spring.application.name"),
                ctx.getEnvironment().getProperty("server.port"));
        LOG.info("Connected to RabbitMQ at: [{}] on Port[{}]",
                ctx.getEnvironment().getProperty("spring.rabbitmq.host"),
                ctx.getEnvironment().getProperty("spring.rabbitmq.port"));
    }

}
