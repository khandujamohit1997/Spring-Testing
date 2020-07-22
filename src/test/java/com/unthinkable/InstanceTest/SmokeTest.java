package com.unthinkable.InstanceTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.unthinkable.controller.HomeController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    HomeController homeController;

    @BeforeAll
    static void init() {
        System.out.println("I am executing myself at first....");
    }

    @BeforeEach
    void setup() {
        homeController = new HomeController();
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(homeController).isNotNull();
    }

    @AfterAll
    static void end() {
        System.out.println("I am executing myself at last....");
    }

}
