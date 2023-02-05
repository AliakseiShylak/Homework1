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
        double oldMember, currentMember, newMember;
        if (n < 0) {
            System.out.println("Error. Value of n must be greater than or equal to 0.");
            return;
        }
        if (n > 1) {
            oldMember = 0;
            currentMember = 1;
            for (int i = 2; i <= n; i++) {
                newMember = oldMember + currentMember;
                oldMember = currentMember;
                currentMember = newMember;
                if (newMember % 2 == 0) {
                    sum += newMember;
                }
            }
        }        // Проверка для n=0 или 1 не выполнялась, т.к. sum не изменится (равно 0)
        System.out.println("Sum = " + sum);
    }
}