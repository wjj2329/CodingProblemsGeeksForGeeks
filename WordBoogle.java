package com.example.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};

Output:  Following words of dictionary are present
         GEEKS, QUIZ

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer x denoting the no of words in the dictionary. Then in the next line are x space separated strings denoting the contents of the dictinory. In the next line are two integers N and M denoting the size of the boggle. The last line of each test case contains NxM space separated values of the boggle.

Output:
For each test case in a new line print the space separated sorted distinct words of the dictionary which could be formed from the boggle. If no word can be formed print -1.

Constraints:
1<=T<=10
1<=x<=10
1<=n,m<=7

Example:
Input:
1
4
GEEKS FOR QUIZ GO
3 3
G I Z U E K Q S E
*/

Output:
GEEKS QUIZ


class GFG {

    public static void recursion(Set<String> wordsFound, Set<String> dictionary, char[][] board, StringBuilder word, boolean[][] visited, int x, int y, int maxWordSize) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || word.length() > maxWordSize)
            return;
        //System.out.println(x+" "+y);
        if (visited[x][y])
            return;
        word.append(board[x][y]);
        if (dictionary.contains(word.toString()))
            wordsFound.add(word.toString());
        visited[x][y] = true;
        //System.out.println(word.toString());
        recursion(wordsFound, dictionary, board, word, visited, x, y + 1, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x, y - 1, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x + 1, y, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x - 1, y, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x + 1, y + 1, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x - 1, y + 1, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x + 1, y - 1, maxWordSize);
        recursion(wordsFound, dictionary, board, word, visited, x - 1, y - 1, maxWordSize);
        word.deleteCharAt(word.length() - 1);
        visited[x][y] = false;

    }

    public static boolean[][] deepCopy(boolean[][] old) {
        boolean[][] newArr = new boolean[old.length][old[0].length];
        for (int x = 0; x < old.length; x++) {
            for (int y = 0; y < old[0].length; y++) {
                newArr[x][y] = old[x][y];
            }
        }
        return newArr;
    }

    public static boolean[][] createBoolArray(int x, int y) {
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < visited.length; i++) {
            for (int u = 0; u < visited[i].length; u++) {
                visited[i][u] = false;
            }
        }
        return visited;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            String words = reader.readLine();
            String[] dictionaryString = reader.readLine().split(" ");
            Set<String> dictionary = new HashSet<>();
            int biggestWord = 0;
            for (String word : dictionaryString) {
                dictionary.add(word);
                if (word.length() > biggestWord)
                    biggestWord = word.length();
            }
            String[] dimensions = reader.readLine().split(" ");
            String[] letters = reader.readLine().split(" ");
            char[][] board = new char[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
            int itterator = 0;
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    board[x][y] = letters[itterator].charAt(0);
                    itterator++;
                }
            }
            Set<String> wordsFound = new TreeSet<>();
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    recursion(wordsFound, dictionary, board, new StringBuilder(), createBoolArray(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])), x, y, biggestWord);
                }

            }
            if (wordsFound.isEmpty()) {
                System.out.print(-1);
            }
            for (String word : wordsFound)
                System.out.print(word + " ");
            System.out.println();
        }
    }
}
