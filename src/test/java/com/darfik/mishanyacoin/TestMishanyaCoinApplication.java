package com.darfik.mishanyacoin;

import org.springframework.boot.SpringApplication;

public class TestMishanyaCoinApplication {

    public static void main(String[] args) {
        SpringApplication.from(MishanyaCoinApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
