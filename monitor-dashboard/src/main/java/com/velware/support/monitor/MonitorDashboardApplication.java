package com.velware.support.monitor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableHystrixDashboard
public class MonitorDashboardApplication {

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(MonitorDashboardApplication.class).web(true).run(args);
    }
}

