/*
 * Дан некоторый двумерный массив "int[][] matrix".
 * Нужно определить каких чисел в нем больше, положительных или отрицательных.
 */
public class Task4 {
    public static void main(String[] args) {
        int[][] array = {
                {-1, 5, -4, 0, 7},
                {11, -5, -3, -5},
                {-7, 3, 4, -7, 0, 1}
        };
        int counterPlusMinus = 0;
        int counterNotZero = 0;
        for (int x[] : array) {
            for (int y : x) {
                if (y > 0) {
                    counterPlusMinus++;
                    counterNotZero++;
                }
                if (y < 0) {
                    counterPlusMinus--;
                    counterNotZero++;
                }
            }
        }
        if (counterPlusMinus > 0) {
            System.out.println("There are more positive numbers in the array.");
        }
        if (counterPlusMinus < 0) {
            System.out.println("There are more negative numbers in the array.");
        }
        if (counterPlusMinus == 0 && counterNotZero == 0) {
            System.out.println("All elements in the array are equal to zero.");
        }
        if (counterPlusMinus == 0 && counterNotZero != 0) {
            System.out.println("The array has the same quantity of positive and negative elements.");
        }
    }
}