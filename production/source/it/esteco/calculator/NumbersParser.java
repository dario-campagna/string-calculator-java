package it.esteco.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumbersParser {

    private Pattern pattern;
    private Matcher matcher;
    private String delimiter;

    public NumbersParser() {
        this.delimiter = "[\n,]";
        this.pattern = Pattern.compile("//([^\\d]*?)\n");
    }

    public List<Integer> parse(String numbers) {
        if (hasCustomDelimiter(numbers)) {
            delimiter = matcher.group(1).toString();
            numbers = removeDelimiterDefinition(numbers);
        }
        return Arrays.stream(numbers.split(delimiter))
                .map(stringToInteger())
                .collect(Collectors.toList());
    }

    private String removeDelimiterDefinition(String numbers) {
        return numbers.substring(3 + delimiter.length(), numbers.length());
    }

    private boolean hasCustomDelimiter(String numbers) {
        matcher = pattern.matcher(numbers);
        return matcher.find();
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
