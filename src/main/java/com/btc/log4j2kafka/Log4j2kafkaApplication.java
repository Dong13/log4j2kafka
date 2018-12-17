package com.btc.log4j2kafka;

import com.btc.boot.service.ProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Log4j2kafkaApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(Log4j2kafkaApplication.class, args);


//        ProducerService producerService = applicationContext.getBean(ProducerService.class);
//        producerService.send();

        Timer timer = new Timer();
        timer.log();
    }
}
