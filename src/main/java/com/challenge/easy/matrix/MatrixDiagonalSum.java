package com.challenge.easy.matrix;

/**
    #

     Given a square matrix mat, return the sum of the matrix diagonals.

     Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.



     Example 1:
        1 2 3
        4 5 6
        7 8 9
     Primary diagonal 1, 5, 9
     Secondary diagonal 3, 5, 7
     https://assets.leetcode.com/uploads/2020/08/14/sample_1911.png

     Input: mat = [[1,2,3],
     [4,5,6],
     [7,8,9]]
     Output: 25
     Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
     Notice that element mat[1][1] = 5 is counted only once.

     Example 2:
         Input: mat = [[1,1,1,1],
         [1,1,1,1],
         [1,1,1,1],
         [1,1,1,1]]
         Output: 8

     Example 3:
         Input: mat = [[5]]
         Output: 5

     Constraints:

         * n == mat.length == mat[i].length
         * 1 <= n <= 100
         * 1 <= mat[i][j] <= 100
 */
public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat)
    {
        int diag1 = 0;
        int diag2 = 0;
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            // Sumar elemento de la diagonal principal
            sum += mat[i][i];
            // Sumar elemento de la diagonal secundaria
            // Evitar duplicar el centro en matrices de tamaño impar
            if (i != n - 1 - i) {  // Si el el valor en el indice i es diferente al valor del que esta en el indice del ultimo elemento
                sum += mat[i][n - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum(mat));

    }
}