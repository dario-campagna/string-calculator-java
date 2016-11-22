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
        Pattern patter = Pattern.compile("//(\\D)\n(.*)");
        Matcher matcher = patter.matcher(string);
        if (matcher.find()) {
            return split(matcher.group(2), matcher.group(1));
        } else {
            return split(string, ",|\n");
        }
    }

    private static String[] split(String string, String regex) {
        if (string.isEmpty()) {
            return new String[0];
        } else {
            return string.split(regex);
        }
    }

    private static IntStream convertToIntegers(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt);
    }
}
