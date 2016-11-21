package it.esteco.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddNumbersTest {

    private int sum;
    private String numbers;

    public AddNumbersTest(int sum, String numbers) {
        this.sum = sum;
        this.numbers = numbers;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, ""},
                {1, "1"},
                {12, "12"},
                {20, "13,7"},
                {-6, "-6"},
                {-3, "-5,2"},
                {-4, "4,-8"},
                {-12, "-11,-1"},
                {0, "3,9,-12"},
                {33, "0,1,1,2,3,5,8,13"},
                {6, "1\n2,3"}
        });
    }

    @Test
    public void addNumbers() throws Exception {
        assertEquals(sum, new StringCalculator().add(numbers));
    }

}
