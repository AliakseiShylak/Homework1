/*
 * N студентов стоят в очереди за стипендией. Каждый студент имеет учебный рейтинг.
 * Деканат должен выдать стипендию таким образом, чтобы: каждый студент получил хотя
 * бы 1 рубль, студенты с более высоким рейтингом получили больше рублей, чем их
 * соседи в очереди. Копеек в деканате нет. Какое минимальное количество рублей
 * должно быть у деканата? На вход подаётся массив из N элементов, содержащий
 * рейтинги для каждого студента. На выходе ожидается число, обозначающее минимальное
 * количество рублей, которых должно хватить студентам.
 */
public class TaskSecondStar {
    public static void main(String[] args) {
        int[] rating = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        int[] stipend = new int[rating.length];
        boolean[] issued = new boolean[rating.length];
        int counter = 0;
        int sum = 0;
        int currentStipend = 2;
        if (!checkArray(rating)) {
            System.out.println("Error. Rating for all students must be more than zero.");
            return;
        }
        for (int i = 0; i < stipend.length; i++) {
            stipend[i] = 1;
            issued[i] = false;
        }
        if (rating[0] <= rating[1]) {
            issued[0] = true;
            counter++;
        } else {
            stipend[0]++;
        }
        if (rating[rating.length - 1] <= rating[rating.length - 2]) {
            issued[rating.length - 1] = true;
            counter++;
        } else {
            stipend[rating.length - 1]++;
        }
        //      while (counter < issued.length - 2) {

        for (int i = 1; i < stipend.length - 1; i++) {
            if ((rating[i] <= rating[i - 1]) && (rating[i] <= rating[i + 1]) && !issued[i]) {
                issued[i] = true;
                counter++;
            } else {
                stipend[i]++;
            }
        }

        while (counter < issued.length) {
            if (!issued[0] && !issued[1] && rating[0] > rating[1]) {
                stipend[0]++;
            }
            for (int i = 1; i < stipend.length - 1; i++) {
                if (!issued[i]) {
                    if ((!issued[i - 1] && rating[i] > rating[i - 1]) || (!issued[i + 1] && rating[i] > rating[i + 1])) {
                        stipend[i]++;
                    }
                }
            }
            if (!issued[rating.length - 1] && !issued[rating.length - 2] && rating[rating.length - 1] > rating[rating.length - 2]) {
                stipend[rating.length - 1]++;
            }
            for (int i = 0; i < stipend.length; i++) {
                if (!issued[i] && stipend[i] == currentStipend) {
                    issued[i] = true;
                    counter++;
                }
            }
            currentStipend++;
        }

        System.out.println("Rating\t|\tStipend");
        for (int i = 0; i < stipend.length; i++) {
            System.out.println(rating[i] + "\t\t|\t" + stipend[i]);
            sum += stipend[i];
        }
        System.out.println("Total sum = " + sum);
    }

    public static boolean checkArray(int[] arrayX) {
        for (int i = 0; i < arrayX.length; i++) {
            if (arrayX[i] <= 0) {
                return false;
            }
        }
        return true;
    }
}
