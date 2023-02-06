/*
 * Задача 6:
 * Необходимо найти самое длинное слово в строке.
 *
 * Задача 7:
 * Необходимо узнать есть ли в строке слова которые начинаются
 * и заканчиваются на букву "а".
 */

public class HW2Task6and7 {
    public static void main(String[] args) {
        String str = "ррооd aa fgЩыhj, ahdga a arrja.";
        String[] word;
        int counter = 0;
        int max = 0;
        int indexMax = 0;
        char symbol = 'a';

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
            if (word[i].indexOf(symbol) == 0 && word[i].lastIndexOf(symbol) == word[i].length() - 1) {
                System.out.println(word[i]);
                counter++;
            }
        }
        switch (counter) {
            case 0:
                System.out.println("There are no words for which the first and last character is " + symbol);
                break;
            case 1:
                System.out.println("There is only one word for which the first and last character is " + symbol);
                break;
            default:
                System.out.println("There are " + counter + " words for which the first and last character is " + symbol);
                break;
        }
        System.out.println("Longest word: " + word[indexMax]);
    }
}
