/*
 *  Есть некоторый массив, состоящий из целых чисел "int[] array", есть некоторое
 *  число "n". Необходимо посчитать сумму всех элементов массива, однако если в
 *  массиве встречается число "n" то в сумму его включать не нужно.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 2, 7, 11, 5, -3, 5, -7, 3, 4, 7, 9, 1};
        int n = 7;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != n) {
                sum += array[i];
            }
        }
        System.out.println("Sum = " + sum);
    }
}
