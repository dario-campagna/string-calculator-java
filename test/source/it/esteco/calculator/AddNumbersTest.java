package it.esteco.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void unknownAmountOfNumbers() throws Exception {
        assertEquals(18, Calculator.add("5,6,7"));
    }

    @Test
    public void newlineAsDelimiter() throws Exception {
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void customDelimiter() throws Exception {
        assertEquals(15, Calculator.add("//[;]\n7;8"));
        assertEquals(15, Calculator.add("//[\n]\n7\n8"));
    }

    @Test
    public void throwsExceptionWithOneNegative() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed [-6]");

        Calculator.add("-6");
    }

    @Test
    public void throwsExeptionWithMoreThanOneNegative() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed [-25, -46]");

        Calculator.add("-25\n5,-46");
    }

    @Test
    public void ignoreIntegersGreaterThanOneThousand() throws Exception {
        assertEquals(2, Calculator.add("2,1001"));
    }

    @Test
    public void customDelimiterOfMoreThanOneChar() throws Exception {
        assertEquals(10, Calculator.add("//[---]\n3---6---1"));
        assertEquals(10, Calculator.add("//[\n\n]\n3\n\n6\n\n1"));
    }

    @Test
    public void multipleCustomDelimitersOfOneChar() throws Exception {
        assertEquals(30, Calculator.add("//[#][°]\n15#5°10"));
    }

    @Test
    public void multipleCustomDelimitersOfMoreThanOneChar() throws Exception {
        assertEquals(40, Calculator.add("//[:::][---][,,,]\n15:::5---10,,,10"));
    }
}
