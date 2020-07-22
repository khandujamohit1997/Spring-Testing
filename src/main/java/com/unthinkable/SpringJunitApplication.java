package com.unthinkable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJunitApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJunitApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(add(1,1));
        System.out.println(add(4,4));
        System.out.println(add(3,1));
        System.out.println(add(1,3));
    }

    public static int add(int a, int b) {
        return (a + b);
    }
}
