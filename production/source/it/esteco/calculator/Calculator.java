package it.esteco.calculator;

public class Calculator {
    public static int add(String string) {
        if (string.isEmpty()) {
            return 0;
        } else {
            String[] tokens = string.split(",");
            int sum = 0;
            for (String token : tokens) {
                sum += Integer.valueOf(token);
            }
            return sum;
        }
    }
}
