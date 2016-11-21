package it.esteco.calculator;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private NumbersParser parser;

    public StringCalculator(NumbersParser parser) {
        this.parser = parser;
    }

    public int add(String numbersAsText) throws Exception {
        List<Integer> integers = parser.parse(numbersAsText);
        List<Integer> negatives = integers.stream().filter(integer -> integer < 0).collect(Collectors.toList());
        if (negatives.isEmpty()) {
            return integers.stream().reduce(0, (a, b) -> a + b);
        } else {
            throw new Exception("Negatives not allowed " + negatives);
        }
    }
}
