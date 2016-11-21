package it.esteco.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbersAsText) {
        return parse(numbersAsText).stream().reduce(0, (a, b) -> a + b);
    }

    private List<Integer> parse(String numbersAsText) {
        return Arrays.stream(numbersAsText.split("[\n,]"))
                .map(stringToInteger())
                .collect(Collectors.toList());
    }

    private Function<String, Integer> stringToInteger() {
        return number -> {
            if (number.isEmpty()) {
                return 0;
            } else {
                return Integer.valueOf(number);
            }
        };
    }
}
