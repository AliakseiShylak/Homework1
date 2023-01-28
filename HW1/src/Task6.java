/*
 * Даны две квадратные матрицы.
 * Необходимо написать программу которая посчитает их сумму и разности.
 */
public class Task6 {
    public static void main(String[] args) {
        int[][] matrixA = {
                {1, 0, 0, 6},
                {2, 3, 0, 0},
                {4, 5, 6, 0},
                {7, 8, 9, 1}
        };
        int[][] matrixB = {
                {1, 6, -6, 0},
                {2, -3, 4, 7},
                {-4, 5, 6, 0},
                {2, -4, 9, 1}
        };
        if (!isSquareMatrix(matrixA)) {
            System.out.println("matrixA is not square matrix");
            return;
        }
        if (!isSquareMatrix(matrixB)) {
            System.out.println("matrixB is not square matrix");
            return;
        }
        System.out.println("matrixA + matrixB");
        printMatrix(sumMatrix(matrixA, matrixB));
        System.out.println("matrixA - matrixB");
        printMatrix(subtractMatrix(matrixA, matrixB));
        System.out.println("matrixB - matrixA");
        printMatrix(subtractMatrix(matrixB, matrixA));
    }

    public static boolean isSquareMatrix(int[][] matrixX) {
        for (int i = 0; i < matrixX.length; i++) {
            if (matrixX.length != matrixX[i].length) {
                return false;
            }
        }
        return true;
    }

    public static int[][] sumMatrix(int[][] matrixX, int[][] matrixY) {
        int[][] matrixZ = new int[matrixX.length][matrixX.length];
        for (int i = 0; i < matrixZ.length; i++) {
            for (int j = 0; j < matrixZ.length; j++) {
                matrixZ[i][j] = matrixX[i][j] + matrixY[i][j];
            }
        }
        return matrixZ;
    }

    public static int[][] subtractMatrix(int[][] matrixX, int[][] matrixY) {
        int[][] matrixZ = new int[matrixX.length][matrixX.length];
        for (int i = 0; i < matrixZ.length; i++) {
            for (int j = 0; j < matrixZ.length; j++) {
                matrixZ[i][j] = matrixX[i][j] - matrixY[i][j];
            }
        }
        return matrixZ;
    }

    public static void printMatrix(int[][] matrixX) {
        for (int i = 0; i < matrixX.length; i++) {
            for (int j = 0; j < matrixX[i].length; j++) {
                System.out.print(matrixX[i][j]);
                if (j < matrixX.length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        return;
    }
}
