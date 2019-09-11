package com.example.lib;/*package whatever //do not write package name here
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class GFG {
    public static boolean isCorrectBracket(char letter, char stackLetter) {
        switch (letter) {
            case ')':
                if (stackLetter == '(')
                    return true;
                else
                    return false;
            case '}':
                if (stackLetter == '{')
                    return true;
                else
                    return false;
            case ']':
                if (stackLetter == '[')
                    return true;
                else
                    return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            String word = reader.readLine();
            Stack<Character> myStack = new Stack<>();
            boolean balanced = true;
            for (int x = 0; x < word.length(); x++) {
                if (word.charAt(x) == '{' || word.charAt(x) == '(' || word.charAt(x) == '[') {
                    myStack.push(word.charAt(x));
                } else {
                    if (myStack.isEmpty()) {
                        balanced = false;
                        break;
                    }
                    if (!isCorrectBracket(word.charAt(x), myStack.pop())) {
                        balanced = false;
                        break;
                    }

                }
            }
            if (balanced && myStack.isEmpty())
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }
}
