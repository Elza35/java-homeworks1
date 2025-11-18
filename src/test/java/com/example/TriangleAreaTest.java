package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {
    
    @Test
    void testCalculateArea() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4));
    }
}