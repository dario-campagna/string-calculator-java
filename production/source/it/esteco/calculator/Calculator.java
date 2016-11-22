package it.esteco.calculator;

public class Calculator {
    public static int add(String string) {
        if (string.isEmpty()) {
            return 0;
        } else if (string.length() == 1){
            return Integer.valueOf(string);
        } else {
            return Integer.valueOf(string.substring(0,1)) + Integer.valueOf(string.substring(2,3));
        }
    }
}
