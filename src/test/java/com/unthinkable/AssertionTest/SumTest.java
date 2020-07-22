package com.unthinkable.AssertionTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SumTest {

    int[] numbers;

    @BeforeEach
    void init() {
        numbers = new int[]{0, 1, 2, 3, 4};
    }

    @Test
    void lambdaExpression() {
        assertTrue(Stream.of(1, 2, 3, 4, 5)
            .mapToInt(i -> i)
            .sum() > 10, () -> "Sum should be greater than 10");
    }

    @Test
    void groupAssertions() {
        assertAll("numbers",
            () -> assertEquals(numbers[0], 0),
            () -> assertEquals(numbers[3], 3),
            () -> assertEquals(numbers[4], 4)
        );
    }
}
