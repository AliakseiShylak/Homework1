/*
 * Дан некоторый массив "int[] array", необходимо инвертировать его.
 */
public class Task3 {
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 2, 7, 11, 5, -3, 5, -7, 3, 4, 7, 9, 1};
        int firstIndex = 0;
        int lastIndex = array.length-1;
        int buffer;
        System.out.print("Initial array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        while (firstIndex < lastIndex) {
            buffer = array[firstIndex];
            array[firstIndex] = array[lastIndex];
            array[lastIndex] = buffer;
            firstIndex++;
            lastIndex--;
        }
        System.out.print("\nInverted array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
