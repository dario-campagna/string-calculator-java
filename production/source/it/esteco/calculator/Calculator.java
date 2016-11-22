package it.esteco.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Calculator {
    public static int add(String string) {
        String[] tokens = tokenize(string);
        IntStream intStream = convertToIntegers(tokens);
        return intStream.reduce(0, (a, b) -> a + b);
    }

    private static String[] tokenize(String string) {
        if (string.isEmpty()) {
            return new String[0];
        } else if (string.startsWith("//")) {
            Pattern patter = Pattern.compile("//(\\D)\n(.*)");
            Matcher matcher = patter.matcher(string);
            matcher.find();
            return matcher.group(2).split(matcher.group(1));
        } else {
            return string.split(",|\n");
        }
    }

    private static IntStream convertToIntegers(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt);
    }
}
