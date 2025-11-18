package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {
    
    @Test
    public void testCompareFirstGreater() {
        assertEquals(NumberComparator.compare(10, 5), "10 больше 5");
    }
    
    @Test
    public void testCompareEqual() {
        assertEquals(NumberComparator.compare(5, 5), "Числа равны");
    }
}