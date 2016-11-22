package it.esteco.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DelimitersRegexTest {

    @Test
    public void singleDelimiter() throws Exception {
        assertEquals(";", new DelimitersRegex("[;]").toString());
    }

    @Test
    public void multipleDelimiters() throws Exception {
        assertEquals(";|:", new DelimitersRegex("[;][:]").toString());
    }

    @Test
    public void delimiterOfMoreThanOneChar() throws Exception {
        assertEquals(":::", new DelimitersRegex("[:::]").toString());
    }

    @Test
    public void multipleDelimitersOfMoreThanOneChar() throws Exception {
        assertEquals(":::|;;;", new DelimitersRegex("[:::][;;;]").toString());
    }
}
