package it.esteco.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.length() > 1) {
            String[] numbersAsStrings = numbers.split(",");
            int sum = 0;
            for (String number : numbersAsStrings) {
                sum += Integer.valueOf(number);
            }
            return sum;
        } else {
            return Integer.valueOf(numbers);
        }
    }
}
