/*
 * Необходимо найти сумму всех четных чисел в последовательности Фибоначчи,
 * до определенного индекса "n".
 * ВНИМАНИЕ:
 * Решение приведено именно для ИНДЕКСА n, а не для n ЧЛЕНОВ последовательности.
 */
public class Task2 {
    public static void main(String[] args) {
        int n = 30;
        double sum = 0;
        double[] sequence;
        if (n < 0) {
            System.out.println("Error. Value of n must be greater than or equal to 0.");
            return;
        }
        sequence = new double[n + 1];
        if (n > 1) {
            sequence[0] = 0;
            sequence[1] = 1;
            for (int i = 2; i <= n; i++) {
                sequence[i] = sequence[i - 2] + sequence[i - 1];
                if (sequence[i] % 2 == 0) {
                    sum += sequence[i];
                }
            }
        }        // Проверка для n=0 или 1 не выполнялась, т.к. sum не изменится (равно 0)
        System.out.println("Sum = " + sum);
    }
}
