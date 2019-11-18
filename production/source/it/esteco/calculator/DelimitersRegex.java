package it.esteco.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimitersRegex {

    private final List<String> delimiters = new ArrayList<>();

    public DelimitersRegex(String string) {
        if (string.startsWith("[")) {
            findAllDelimiters(string);
        } else {
            delimiters.add(string);
        }
    }

    private void findAllDelimiters(String string) {
        Pattern patter = Pattern.compile("\\[([^\\[\\]]+)\\]");
        Matcher matcher = patter.matcher(string);
        while (matcher.find()) {
            delimiters.add(matcher.group(1));
        }
    }

    @Override
    public String toString() {
        return String.join("|", delimiters);
    }
}
