package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {
    
    @Test
    public void testCalculateArea() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeValues() {
        TriangleArea.calculateArea(-5, 4);
    }
}