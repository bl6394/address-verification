package com.abcfitness.addressverification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AddressVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressVerificationApplication.class, args);
    }

}
