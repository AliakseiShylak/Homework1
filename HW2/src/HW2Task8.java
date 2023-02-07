/*
 * Задача 8:
 * Необходимо извлечь из строки и распечатать номер карты
 * (XXXX-XXXX-XXXX-XXXX) если он там есть.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW2Task8 {
    public static void main(String[] args) {
        String str = "df ggtrhnb AS0-GF56-4567-NBF3-NFI6 dh mnAS48D0-GF56-4567-NBF3-NFI6gh';,dfhd";
        Pattern pattern = Pattern.compile("[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}");
        Matcher matcher = pattern.matcher(str);
        int counter = 0;

        while (matcher.find()) {
            System.out.println(matcher.group());
            str = str.substring(matcher.start() + 5);
            matcher.reset(str);
            counter++;
        }
        if (counter == 0) {
            System.out.println("There is no card number in the string");
        }
    }
}
