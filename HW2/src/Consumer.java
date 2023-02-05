/*
 * Задача 3:
 * Необходимо создать класс который имеет метод чтобы накапливать 5 последних переданных
 * в него цифровых значений. Так же необходимо создать метод который выводит
 * среднее из накопленных значений.
 */
public class Consumer {
    private int[] arrayNumber = new int[5];
    private int quantity = 0;

    public void consume(int number) {
        for (int i = 4; i > 0; i--) {
            arrayNumber[i] = arrayNumber[i - 1];
        }
        arrayNumber[0] = number;
        if (quantity < 5) {
            quantity++;
        }
        return;
    }

    public double avg() {
        int sum = 0;

        if (quantity == 0) {
            return 0;
        }
        for (int i = 0; i < quantity; i++) {
            sum += arrayNumber[i];
        }
        return (double) sum / (quantity);
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.consume(3);
        System.out.println(consumer.avg());
        consumer.consume(1);
        System.out.println(consumer.avg());
        consumer.consume(1);
        System.out.println(consumer.avg());
        consumer.consume(1);
        System.out.println(consumer.avg());
        consumer.consume(1);
        System.out.println(consumer.avg());
        consumer.consume(1);
        System.out.println(consumer.avg());
    }
}
