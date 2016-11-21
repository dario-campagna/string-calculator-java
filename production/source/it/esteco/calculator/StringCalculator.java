package it.esteco.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String[] numbersAsStrings = numbers.split("[\n,]");
            int sum = 0;
            for (String number : numbersAsStrings) {
                sum += Integer.valueOf(number);
            }
            return sum;
        }
    }
}
