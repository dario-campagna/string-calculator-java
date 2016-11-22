package it.esteco.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    public static int add(String string) throws Exception {
        String[] tokens = tokenize(string);
        List<Integer> integers = convertToIntegers(tokens);
        List<Integer> negatives = integers.stream().filter(integer -> integer < 0).collect(Collectors.toList());
        if (negatives.size() == 0) {
            return integers.stream().reduce(0, (a, b) -> a + b);
        } else {
            throw new Exception("Negatives not allowed " + negatives);
        }
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

    private static List<Integer> convertToIntegers(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
