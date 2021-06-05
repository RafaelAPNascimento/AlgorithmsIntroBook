package _01Foundations.ch01;

public class MatrixProduct {


    public static int[][] multiply(int[][] A, int[][] B) {

        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < C.length; i++) {

            for (int j = 0; j < C.length; j++) {

                for (int k = 0; k < B.length; k++) {

                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
