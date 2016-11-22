package it.esteco.calculator;

public class Calculator {
    public static int add(String string) {
        if (string.isEmpty()) {
            return 0;
        } else if (string.length() == 1){
            return Integer.valueOf(string);
        } else if (string.length() == 3) {
            return Integer.valueOf(string.substring(0,1)) + Integer.valueOf(string.substring(2,3));
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
