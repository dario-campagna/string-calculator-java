package it.esteco.calculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Calculator {
    public static int add(String string) {
        String[] tokens = tokenize(string);
        IntStream intStream = convertToIntegers(tokens);
        return intStream.reduce(0, (a, b) -> a + b);
    }

    private static String[] tokenize(String string) {
        return string.isEmpty() ? new String[0] : string.split(",|\n");
    }

    private static IntStream convertToIntegers(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt);
    }
}
