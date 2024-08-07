package com.challenge.easy.string;

import java.util.Arrays;
import java.util.Comparator;

/**
    # Sorting the Sentence

     A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

     A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

     For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
     Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

     Example 1:
         Input: s = "is2 sentence4 This1 a3"
         Output: "This is a sentence"
         Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

     Example 2:
         Input: s = "Myself2 Me1 I4 and3"
         Output: "Me Myself and I"
         Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.

     Constraints:

         * 2 <= s.length <= 200
         * s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
         * The number of words in s is between 1 and 9.
         * The words in s are separated by a single space.
         * s contains no leading or trailing spaces.

 */
public class SortingSentence {

    public static String sortSentence(String s)
    {
        String[] words = s.split(" ");

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                // Extraer los numeros de las palabras
                int n1 = getNum(word1) - 1;
                int n2 = getNum(word2) - 1;
                //return n1 < n2 ? -1 : (n1 == n2 ? 0 : 1);
                return Integer.compare(n1, n2);
            }

        });
        for (int i = 0; i < words.length; i++) {
            words[i] = removeNumber(words[i]);
        }

        return String.join(" ", words);
    }

    private static int getNum(String word){
        StringBuilder result = new StringBuilder();
        int number = -1;
        for (int i = 0; i < word.length(); i++) {
            if(Character.isDigit(word.charAt(i))){
                return Character.getNumericValue(word.charAt(i));
            }
        }
        return -1;
    }

    private static String removeNumber(String word){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(!Character.isDigit(word.charAt(i))){
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "This0 is1 a2 sentence3";
        String sortedSentence = sortSentence(sentence);
        System.out.println("Oración ordenada: " + sortedSentence);
    }
}
