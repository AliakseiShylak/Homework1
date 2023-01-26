/*
 * Дан некоторый двумерный массив "int[][] matrix".
 * Нужно определить является ли он нижней треугольной матрицей или же нет.
 */
public class Task5 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0},
                {2, 3, 0, 0},
                {4, 5, 6, 0},
                {7, 8, 9, 1}
        };
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                System.out.println("The matrix is not square, so it cannot be lower triangular.");
                return;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.println("The matrix is not lower triangular.");
                    return;
                }
            }
        }
        // если ни в одном из циклов не сработал return, матрица будет нижнетреугольной.
        System.out.println("The matrix is lower triangular.");
    }
}
