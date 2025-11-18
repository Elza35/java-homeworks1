package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    
    @Test
    void testCompareFirstGreater() {
        assertEquals("10 больше 5", NumberComparator.compare(10, 5));
    }
    
    @Test
    void testCompareEqual() {
        assertEquals("Числа равны", NumberComparator.compare(5, 5));
    }
}