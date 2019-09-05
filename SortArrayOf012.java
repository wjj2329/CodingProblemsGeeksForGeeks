/*Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

Output: 
For each testcase, print the sorted array.

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(myReader.readLine());
        for (int i = 0; i < testCases; i++) {
            myReader.readLine();
            String nums = myReader.readLine();
            String[] arrNums = nums.split(" ");
            int zeros, ones, twos;
            zeros = ones = twos = 0;
            for (int x = 0; x < arrNums.length; x++) {
                switch (arrNums[x]) {
                    case "0": {
                        zeros++;
                        break;
                    }
                    case "1": {
                        ones++;
                        break;
                    }
                    case "2": {
                        twos++;
                        break;
                    }

                }
            }
            for (int y = 0; y < zeros; y++) {
                System.out.print("0 ");
            }
            for (int y = 0; y < ones; y++) {
                System.out.print("1 ");
            }
            for (int y = 0; y < twos; y++) {
                System.out.print("2");
                if (y != twos - 1)
                    System.out.print(" ");
            }
            System.out.println();

        }
    }
}
