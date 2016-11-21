package it.esteco.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbersAsText) {
        int sum = 0;
        for (Integer number : parse(numbersAsText)) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> parse(String numbersAsText) {
        List<Integer> integers = new ArrayList<>();
        for (String number : numbersAsText.split("[\n,]")) {
            if (!number.isEmpty()) {
                integers.add(Integer.valueOf(number));
            }
        }
        return integers;
    }
}
