/*
 * Есть некоторый массив из целых положительних чисел. [1, 0, 4, 8, 9, 1]
 * Необходимо написать программу которая посчитает максимально возможную сумму
 * которую можно получить из данного массива, с условием что элементы включенные в
 * сумму не должны стоять на соседних индексах (должен быть минимум один елемент между ними).
 */
public class TaskFirstStar {
    public static void main(String[] args) {
        int[] array = {1, 1, 4, 8, 9, 1};
        int maxSum = 0;
        int currentSum = 0;
        if (!checkArray(array)) {
            System.out.println("Error. Not all nunbers in the array are positive.");
            return;
        }
        for (int k = 1; k <= (array.length / 2 + array.length % 2); k++) {
            int[] arr = null;
            while ((arr = generateIndexArray(arr, k, array.length)) != null) {
                for (int i = 0; i < arr.length; i++) {
                    currentSum += array[arr[i]];
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                currentSum = 0;
            }
        }
        System.out.println("Maximum sum = " + maxSum);
    }

    public static boolean checkArray(int[] arrayX) {
        for (int i = 0; i < arrayX.length; i++) {
            if (arrayX[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateIndexArray(int[] arr, int sizeCombination, int maxNumber) {
        if (arr == null) {
            arr = new int[sizeCombination];
            for (int i = 0; i < sizeCombination; i++) {
                arr[i] = 2 * i;
            }
            return arr;
        }
        for (int i = sizeCombination - 1; i >= 0; i--) {
            if (arr[i] < maxNumber - 2 * (sizeCombination - i) + 1) {
                arr[i]++;
                for (int j = i; j < sizeCombination - 1; j++) {
                    arr[j + 1] = arr[j] + 2;
                }
                return arr;
            }
        }
        return null;
    }
}