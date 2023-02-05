/*
 * Задача 6:
 * Необходимо найти самое длинное слово в строке.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW2Task6 {
    public static void main(String[] args) {
        String str = "ррооd fgЩыhj, hdg rrj.";
        String[] word;
        int max = 0;
        int indexMax = 0;

        word = str.split("[^а-яА-Яa-zA-Z_0-9]+");
        if (word.length == 0) {
            System.out.println("No words");
            return;
        }
        
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() > max) {
                max = word[i].length();
                indexMax = i;
            }
        }
        System.out.println("Longest word: " + word[indexMax]);

    }
}
