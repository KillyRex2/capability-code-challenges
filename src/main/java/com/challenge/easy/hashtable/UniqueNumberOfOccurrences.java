package com.challenge.easy.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
    # Unique Number of Occurrences

     Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

     Example 1:
         Input: arr = [1,2,2,1,1,3]
         Output: true
         Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

     Example 2:
         Input: arr = [1,2]
         Output: false

     Example 3:
         Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
         Output: true

     Constraints:

         * 1 <= arr.length <= 1000
         * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> occurencesSet = new HashSet<>();

        for(int count : map.values()) {
            if(!occurencesSet.add(count)) { // cuando se cumple que ya esta enla condicion se conv a true pero el if hace return de false
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};

        System.out.println("Input: [1, 2, 2, 1, 1, 3] -> Output: " + uniqueOccurrences(arr1)); // Esperado: true
        System.out.println("Input: [1, 2] -> Output: " + uniqueOccurrences(arr2)); // Esperado: false
        System.out.println("Input: [-3, 0, 1, -3, 1, 1, 1, -3, 10, 0] -> Output: " + uniqueOccurrences(arr3)); // Esperado: true
    }
}
