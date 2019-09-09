package com.example.lib;/*Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.
 

Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. Each test case contains a string str.

Output:
For each test case, print a new line containing the resulting string.

Constraints:
1<=T<=100
1<=Length of string<=50

Example:
Input:
2
geeksforgeek
acaaabbbacdddd

Output:
gksforgk
acac*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class GFG {
    public static void removeDuplicates(StringBuilder word) {
        class Tuple {
            int start, end;

            Tuple(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
        int start = -1;
        int end = -1;
        boolean newSet = true;
        ArrayList<Tuple> removals = new ArrayList<>();
        for (int x = 1; x < word.length(); x++) {
            if (word.charAt(x) == word.charAt(x - 1)) {
                end = x;
                if (newSet) {
                    start = x - 1;
                    newSet = false;
                }
            } else if (start != -1 && end != -1) {
                removals.add(new Tuple(start, end));
                start = -1;
                end = -1;
                newSet = true;
            }
        }
        if (start != -1 && end != -1) {
            removals.add(new Tuple(start, end));
        }
        for (int x = removals.size() - 1; x >= 0; x--) {
            word.replace(removals.get(x).start, removals.get(x).end + 1, "");
        }

    }

    public static boolean containsDupicates(StringBuilder word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(myReader.readLine());
        for (int i = 0; i < testCases; i++) {
            StringBuilder word = new StringBuilder(myReader.readLine());
            while (containsDupicates(word))
                removeDuplicates(word);
            System.out.println(word.toString());

        }
    }
}
