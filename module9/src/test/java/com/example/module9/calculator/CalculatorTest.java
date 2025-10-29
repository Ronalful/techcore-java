package com.example.module9.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    //Task 1
    @Test
    void testAdd() {
        Assertions.assertEquals(3, calculator.add(1, 2));
        Assertions.assertEquals(1, calculator.add(-1, 2));
    }

    //Task 1
    @Test
    void testSubtract() {
        Assertions.assertEquals(-1, calculator.subtract(1, 2));
        Assertions.assertEquals(1, calculator.subtract(-1, -2));
    }

    //Task 2
    @Test
    void testDivide() {
        Assertions.assertEquals(3, calculator.divide(6, 2));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(12, 0));
    }
}