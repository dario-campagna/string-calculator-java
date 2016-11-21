package it.esteco.calculator;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParseNumbersTest {

    @Test
    public void defaultDelimiters() throws Exception {
        assertEquals(Arrays.asList(1, 2, 3), new NumbersParser().parse("1,2\n3"));
    }

    @Test
    public void customDelimiter() throws Exception {
        assertEquals(Arrays.asList(1,2), new NumbersParser().parse("//;\n1;2"));
    }
}