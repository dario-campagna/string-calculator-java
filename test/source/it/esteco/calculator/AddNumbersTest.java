package it.esteco.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {

    @Test
    public void noNumbers() throws Exception {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void oneNumber() throws Exception {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void anotherNumber() throws Exception {
        assertEquals(2, Calculator.add("2"));
    }

    @Test
    public void twoNumbers() throws Exception {
        assertEquals(7, Calculator.add("3,4"));
    }
}
