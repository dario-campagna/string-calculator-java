package it.esteco.calculator;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {

    @Test
    public void zeroNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }
}
