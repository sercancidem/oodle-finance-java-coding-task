package com.oodlefinance.sercan.cidem.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 The main class of the Internal Service Application. This class is used to bootstrap the application,
 enable Feign clients, and enable service discovery.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class InternalServiceApplication {
 
  public static void main(String[] args) {
    SpringApplication.run(InternalServiceApplication.class, args);
  }

}
 
