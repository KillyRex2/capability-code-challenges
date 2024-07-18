package com.challenge.easy.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
    # Pascal's Triangle

     Given an integer numRows, return the first numRows of Pascal's triangle.

     In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

                1
               1 1
              1 2 1
             1 3 3 1
            1 4 6 4 1

     https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif

     Example 1:
         Input: numRows = 5
         Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

     Example 2:
         Input: numRows = 1
         Output: [[1]]

     Constraints:

        * 1 <= numRows <= 30

 */
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            triangle.add(generateRow(i));
        }
        return triangle;
    }

    private static List<Integer> generateRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int j = 1; j <= rowIndex; j++){
            row.add(getValue(rowIndex, j));
        }
        return row;
    }
    private static int getValue(int rowIndex, int colIndex){
        if(colIndex == 0 || colIndex == rowIndex){
            return 1;
        }
        return getValue(rowIndex - 1, colIndex - 1) + getValue(rowIndex - 1, colIndex );
    }
/*
    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            triangle.add(generateRow(i));
        }
        return triangle;
    }

    private static List<Integer> generateRow(int rowIndex){
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int j = 1; j <= rowIndex; j++){
            row.add(getValue(rowIndex, j));
        }
        return row;
    }

    private static int getValue(int rowIndex, int colIndex){
        if (colIndex == 0 || colIndex == rowIndex){
            return 1;
        }

        return getValue(rowIndex - 1, colIndex - 1) + getValue(rowIndex - 1, colIndex);
    }
 */

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);

        for (List<Integer> row : result){
            System.out.println(row);
        }

    }


}

