package it.esteco.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {

    @Test
    public void noNumbers() throws Exception {
        assertEquals(0, Calculator.add(""));
    }
}
