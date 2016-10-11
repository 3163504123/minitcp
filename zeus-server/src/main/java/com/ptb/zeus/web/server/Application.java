package com.ptb.zeus.web.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, MongoRepositoriesAutoConfiguration.class})
@ComponentScan
@ImportResource(value = {"classpath:META-INFO/spring/dubbo-consumer.xml","classpath:META-INFO/spring/dubbo-consumer.xml"})
public class Application {
    static Log log = LogFactory.getLog(Application.class);
    public static void main(String[] args) {
        log.info("sssssssssss");
        SpringApplication.run(Application.class, args);
    }
}
