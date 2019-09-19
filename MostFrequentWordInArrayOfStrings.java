package com.example.lib;

/*Given an array containing N words consisting of lowercase characters. Your task is to find the most frequent word in the array. If multiple words have same frequency, then print the word whose first occurence occurs last in the array as compared to the other strings with same frequency.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test case follows. Each test case contains 2 lines, the size of array N and N words separated by spaces.

Output:
For each testcase, output the most frequent word.

Constraints:
1 <= T <= 100
1 <= N <= 1000

Example:
Input:
3
3
geeks for geeks
2
hello world
3
world wide fund

Output:
geeks
world
fund

Explanation:
Testcase 1: "geeks" comes 2 times.
Testcase 2: "hello" and "world" both have 1 frequency. We print world as it comes last in the input array. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class GFG {

    static class Tuple {
        public int wordCount, location;

        Tuple(int wordCount, int location) {
            this.wordCount = wordCount;
            this.location = location;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            String wordCount = reader.readLine();
            String[] words = reader.readLine().split(" ");
            Map<String, Tuple> wordMap = new HashMap<>();
            int location = 0;
            for (String word : words) {
                location++;
                if (wordMap.containsKey(word)) {
                    Tuple temp = wordMap.get(word);
                    temp.wordCount += 1;
                    wordMap.put(word, temp);
                } else
                    wordMap.put(word, new Tuple(1, location));
            }
            int mostCommonCount = 0;
            String mostCommonWord = "";
            int rightMostlocation = 0;
            for (String key : wordMap.keySet()) {
                if (mostCommonCount < wordMap.get(key).wordCount) {
                    mostCommonCount = wordMap.get(key).wordCount;
                    mostCommonWord = key;
                    rightMostlocation = wordMap.get(key).location;
                } else if (mostCommonCount == wordMap.get(key).wordCount) {
                    if (rightMostlocation < wordMap.get(key).location) {
                        mostCommonWord = key;
                        rightMostlocation = wordMap.get(key).location;
                    }
                }
            }
            System.out.println(mostCommonWord);
        }
    }
}
