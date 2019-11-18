package it.esteco.calculator;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private NumbersParser parser;

    public StringCalculator(NumbersParser parser) {
        this.parser = parser;
    }

    public int add(String numbersAsText) throws Exception {
        List<Integer> integers = getNumbersLessThanOneThousandOne(numbersAsText);
        List<Integer> negatives = getNegativeIntegers(integers);
        if (negatives.isEmpty()) {
            return integers.stream().reduce(0, (a, b) -> a + b);
        } else {
            throw new Exception("Negatives not allowed " + negatives);
        }
    }

    private List<Integer> getNumbersLessThanOneThousandOne(String numbersAsText) {
        return parser.parse(numbersAsText).stream().filter(integer -> integer < 1001).collect(Collectors.toList());
    }

    private List<Integer> getNegativeIntegers(List<Integer> integers) {
        return integers.stream().filter(integer -> integer < 0).collect(Collectors.toList());
    }
}
