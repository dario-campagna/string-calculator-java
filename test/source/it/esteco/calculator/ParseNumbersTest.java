package it.esteco.calculator;

import org.junit.Test;

import java.time.MonthDay;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParseNumbersTest {

    @Test
    public void defaultDelimiters() throws Exception {
        StringParser parser = new StringParser();
        assertEquals(Arrays.asList(1, 2, 3), parser.parse("1,2\n3"));
    }
}
