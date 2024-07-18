package com.challenge.easy.binarysearch;

/**
    # Kth Missing Positive Number

     Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

     Return the kth positive integer that is missing from this array.

     Example 1:
         Input: arr = [2,3,4,7,11], k = 5
         Output: 9
         Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

     Example 2:
         Input: arr = [1,2,3,4], k = 2
         Output: 6
         Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

     Constraints:

         * 1 <= arr.length <= 1000
         * 1 <= arr[i] <= 1000
         * 1 <= k <= 1000
         * arr[i] < arr[j] for 1 <= i < j <= arr.length

     Follow up:

     Could you solve this problem in less than O(n) complexity?
 */
public class KthMissingNumber {

    public static int findKthPositive(int[] arr, int k)
    {
          /*
        int n = arr.length;
        int[] fixed = new int[n];
        int result = 0;
        int missingNumbers = 1;
        for (int i = 0; i < n; i++){
            if (arr[i] != missingNumbers) {
                arr[i] = missingNumbers;
                missingNumbers++;
                System.out.println(missingNumbers);
            }
           result = arr[i] + k - 1;
        }

        return result;

         */

        // Binary Search O(n)

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - (mid + 1) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + k;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4};
        int k = 2;
        int output = findKthPositive(nums, k);
        System.out.println("Resultado: " + output);
    }
}
