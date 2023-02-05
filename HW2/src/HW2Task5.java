/*
 * Задача 5:
 * Необходимо посчитать колличество слов в строке в которых буква
 * "c" встречается 3 и более раз.
 */
public class HW2Task5 {
    public static void main(String[] args) {
        String str = "Noogjo, rvsdxzccewcscefbcg jhtceyjcnbmmmcczxp thew prooda cccccccc cc.";
        char symbol = 'c';
        int counterOfWord = 0;
        int counterOfSymbol = 1;
        int position = 0;
        int nextWord = 0;

        while (position != -1) {
            position = str.indexOf(symbol, position);
            if (str.indexOf(' ', position) == nextWord) {
                counterOfSymbol++;
                if (counterOfSymbol == 3) {
                    counterOfWord++;
                    position = str.indexOf(' ', position);
                }
            } else {
                counterOfSymbol = 1;
                nextWord = str.indexOf(' ', position);
            }
            if (position != -1) {
                position++;
            }
        }
        System.out.println("The letter '" + symbol + "' occurs three times or more in " + counterOfWord + " words.");
    }
}

