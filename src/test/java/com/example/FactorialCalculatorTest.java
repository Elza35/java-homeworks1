package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {
    
    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }
    
    @Test
    void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }
}