package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {
    
    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(10, 5), 15);
    }
    
    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
    }
    
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(10, 0);
    }
}