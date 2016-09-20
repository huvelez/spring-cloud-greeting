package com.velware.support.edge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@Controller
@EnableZuulProxy
@EnableDiscoveryClient
public class EdgeServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(EdgeServerApplication.class);

    static {
        // for localhost testing only
        LOG.warn("Will now disable hostname check in SSL, only to be used during development");
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
    }

    public static void main(String[] args) {

        LOG.info("Edge-server starting...");

        new SpringApplicationBuilder(EdgeServerApplication.class).web(true).run(args);

        LOG.info("Edge-server started.");
    }
}
