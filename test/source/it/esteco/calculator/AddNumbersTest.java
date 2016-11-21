package it.esteco.calculator;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {

    @Test
    public void zeroNumbers() throws Exception {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    public void oneNumber() throws Exception {
        assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    public void anotherSingleNumber() throws Exception {
        assertEquals(2, new StringCalculator().add("2"));
    }

    @Test
    public void twoNumbers() throws Exception {
        assertEquals(20, new StringCalculator().add("13,7"));
    }
}
