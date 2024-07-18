package com.challenge.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
    # First Unique Character in a String
     Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

     Example 1:
         Input: s = "leetcode"
         Output: 0

     Example 2:
         Input: s = "loveleetcode"
         Output: 2

     Example 3:
         Input: s = "aabb"
         Output: -1


     Constraints:

         * 1 <= s.length <= 105
         * s consists of only lowercase English letters.
 */
public class FirstUniqueChar {

    public static int firstUniqChar(String s)
    {
        // Crear un map para contar el número de ocurrencias de cada carácter
        Map<Character, Integer> countMap = new HashMap<>();

        // Primer recorrido: contar las ocurrncias de cada carácter
        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Segundo recorrido: encontrar el primer carácter con una sola ocurrencia
        for(int i = 0; i < s.length(); i++){
            if(countMap.get(s.charAt(i)) == 1){
                return i; // Retornar el índice del primer carácter único
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("Input: " + s1 + " -> Output: " + firstUniqChar(s1)); // Esperado: 0
        System.out.println("Input: " + s2 + " -> Output: " + firstUniqChar(s2)); // Esperado: 2
        System.out.println("Input: " + s3 + " -> Output: " + firstUniqChar(s3)); // Esperado: -1
    }
}
