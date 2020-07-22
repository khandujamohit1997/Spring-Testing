package com.unthinkable.ExceptionTesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExceptionTest {

    @Test
    void UnSupportedOperationException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class,
            () -> {
                throw new UnsupportedOperationException("Not Supported");
            });
        assertEquals(exception.getMessage(), "Not Supported");
    }

    @Test
    void IllegalArgumentException() {
        String str = null;
        assertThrows(IllegalArgumentException.class,
            () -> {
                Integer.valueOf(str);
            });

    }
}
