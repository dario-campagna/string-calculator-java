package it.esteco.calculator;

public class StringCalculator {

    private NumbersParser parser;

    public StringCalculator(NumbersParser parser) {
        this.parser = parser;
    }

    public int add(String numbersAsText) {
        return parser.parse(numbersAsText).stream().reduce(0, (a, b) -> a + b);
    }
}
