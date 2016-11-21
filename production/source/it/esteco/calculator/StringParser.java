package it.esteco.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringParser {
    public List<Integer> parse(String numbers) {
        return Arrays.stream(numbers.split("[\n,]"))
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
