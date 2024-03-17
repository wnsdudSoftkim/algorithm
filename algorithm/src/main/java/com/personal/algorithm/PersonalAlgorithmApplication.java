package com.personal.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by (junyoungcross) flgkselql98@crossangle.io 3/17/24
 */
@SpringBootApplication()
@EnableScheduling
@EnableRetry
@EnableAspectJAutoProxy
public class PersonalAlgorithmApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonalAlgorithmApplication.class, args);
    }
}