package com.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    App calc = new App();

    @Test
    public void testAdd() {
        assertEquals(15, calc.add(10, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, calc.subtract(10, 5));
    }
}