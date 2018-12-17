package com.btc.log4j2kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Timer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Timer.class);

    public void log() throws InterruptedException {
        while (true) {
            LOGGER.info("Inside scheduleTask - Sending logs to Kafka at "
                    + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
