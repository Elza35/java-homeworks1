package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {
    
    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }
    
    @Test
    public void testFactorialOfFive() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegative() {
        FactorialCalculator.calculateFactorial(-5);
    }
}