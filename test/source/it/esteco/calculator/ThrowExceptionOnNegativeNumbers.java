package it.esteco.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ThrowExceptionOnNegativeNumbers {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private String message;
    private String numbers;

    public ThrowExceptionOnNegativeNumbers(String message, String numbers) {
        this.message = message;
        this.numbers = numbers;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
                {"Negatives not allowed [-6]", "-6"},
                {"Negatives not allowed [-5]", "2,-5"},
                {"Negatives not allowed [-12, -11, -1]", "//[:]\n-12:-11:-1"}
        });
    }

    @Test
    public void negativesNotAllowed() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(message);

        new StringCalculator(new NumbersParser()).add(numbers);
    }
}

