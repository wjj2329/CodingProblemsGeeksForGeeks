/*Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            ArrayList<Integer> myNums = new ArrayList();
            for (int u = 0; u < size; u++) {
                myNums.add(scan.nextInt());
            }
            Collections.sort(myNums);

            int triplets = 0;
            for (int u = size - 1; u > 0; u--) {
                int pos1 = 0;
                int pos2 = size - 2;

                while (pos1 < pos2) {
                    if (myNums.get(pos1) + myNums.get(pos2) == myNums.get(u)) {
                        triplets++;
                        pos1++;
                        pos2--;
                    } else if (myNums.get(pos1) + myNums.get(pos2) < myNums.get(u)) {
                        pos1++;
                    } else if (myNums.get(pos1) + myNums.get(pos2) > myNums.get(u)) {
                        pos2--;
                    }

                }
            }
            System.out.println(triplets == 0 ? -1 : triplets);

        }
    }

}
