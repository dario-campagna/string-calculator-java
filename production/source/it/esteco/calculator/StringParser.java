package it.esteco.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {

    public List<Integer> parse(String numbers) {
        String delimiter = "[\n,]";
        Pattern pattern = Pattern.compile("//([^\\d]*?)\n");
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.find()) {
            delimiter = matcher.group(1).toString();
            numbers = numbers.substring(4, numbers.length());

        }
        return Arrays.stream(numbers.split(delimiter))
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
