package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {
    
    @Test
    void testAddition() {
        assertEquals(15, ArithmeticOperations.add(10, 5));
    }
    
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, 
            () -> ArithmeticOperations.divide(10, 0));
    }
}