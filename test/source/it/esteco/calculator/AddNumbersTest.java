package it.esteco.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private StringCalculator stringCalculator = new StringCalculator(new NumbersParser());

    @Test
    public void noNumbers() throws Exception {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void oneNumber() throws Exception {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void anotherNumber() throws Exception {
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void twoNumbers() throws Exception {
        assertEquals(7, stringCalculator.add("3,4"));
    }

    @Test
    public void unknownAmountOfNumbers() throws Exception {
        assertEquals(18, stringCalculator.add("5,6,7"));
    }

    @Test
    public void newlineAsDelimiter() throws Exception {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void customDelimiter() throws Exception {
        assertEquals(15, stringCalculator.add("//;\n7;8"));
        assertEquals(15, stringCalculator.add("//-\n7-8"));
    }

    @Test
    public void throwsExceptionWithOneNegative() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed [-6]");

        stringCalculator.add("-6");
    }

    @Test
    public void throwsExceptionWithMoreThanOneNegative() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed [-25, -46]");

        stringCalculator.add("-25\n5,-46");
    }

    @Test
    public void ignoreIntegersGreaterThanOneThousand() throws Exception {
        assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    public void customDelimiterOfMoreThanOneChar() throws Exception {
        assertEquals(10, stringCalculator.add("//[---]\n3---6---1"));
        assertEquals(10, stringCalculator.add("//[°°]\n3°°6°°1"));
    }

    @Test
    public void multipleCustomDelimitersOfOneChar() throws Exception {
        assertEquals(30, stringCalculator.add("//[#][°]\n15#5°10"));
    }

    @Test
    public void multipleCustomDelimitersOfMoreThanOneChar() throws Exception {
        assertEquals(40, stringCalculator.add("//[:::][---][,,,]\n15:::5---10,,,10"));
    }
}
