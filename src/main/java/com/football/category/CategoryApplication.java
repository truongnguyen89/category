package com.football.category;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;

@EnableAsync
@EnableJpaAuditing
@EnableAutoConfiguration
//@EnableFeignClients(basePackages = {"com.ecpay.common.feign"})
//@ComponentScan(basePackages = "com.ecpay.*")
@EnableEurekaClient
@SpringBootApplication
public class CategoryApplication {

    //    public static void main(String[] args) {
//        SpringApplication.run(CategoryApplication.class, args);
//    }
    private static final Logger LOGGER = LogManager.getLogger(CategoryApplication.class);

    public static void main(String[] args) {
        long id = System.currentTimeMillis();
        LOGGER.info("[B][" + id + "] >>>>>>>>>>>>>>>>>>>>>>>>>> Start EcpayFinanceApplication ...");
        SpringApplication app = new SpringApplication(CategoryApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String ipServer = "localhost";
        try {
            ipServer = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            ipServer = env.getProperty("server.address") != null ? env.getProperty("server.address") : "localhost";
        }
        LOGGER.info("----------------------------------------------------------");
        LOGGER.info("   Application         : " + env.getProperty("spring.application.name"));
        LOGGER.info("   Url                 : " + protocol + "://" + ipServer + ":" + env.getProperty("server.port"));
        LOGGER.info("   Profile(s)          : " + env.getActiveProfiles()[0]);
        LOGGER.info("----------------------------------------------------------");

        LOGGER.info("[E][" + id + "][Duration = " + (System.currentTimeMillis() - id) + "] >>>>>>>>>>>>>>>>>>>>>>>>>> End Start EcpayFinanceApplication ...");
    }
}
