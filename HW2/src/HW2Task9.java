/*
 * Задача 9:
 * Реализовать программу которая проверит содержит ли строка некое слово, и если да,
 * то напечатает индекс первого символа данного слова.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW2Task9 {
    public static void main(String[] args) {
        String str = "One: - one, ones one!"; //
        String word = "one";
        Pattern pattern = Pattern.compile("\\b" + word.toLowerCase() + "\\b");
        Matcher matcher = pattern.matcher(str.toLowerCase());
        int counter = 0;

        while (matcher.find()) {
            System.out.println(matcher.start());
            counter++;
        }
        if (counter == 0) {
            System.out.println("The string does not contain the given word");
        }
    }
}
