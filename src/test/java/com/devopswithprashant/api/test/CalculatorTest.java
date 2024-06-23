package com.devopswithprashant.api.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {

    private Calculator c = new Calculator();

    @Test
    void contextLoads() {

    }

    @Test
    void testSum() {
        int expectedResult = 17;
        int actualResult = c.doSum(12, 3, 2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testProduct() {
        int expectedResult = 12;
        int actualResult = c.doProduct(2, 6);

        assertEquals(expectedResult, actualResult);
    }

}
