
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/* Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test case contains 3 lines of input. The first line contains an integer N denoting the size of the array. The second line contains element of array A[]. The third line contains elements of the array B[].

Output:
For each test case, print 1 if the arrays are equal else print 0.

Constraints:
1<=T<=100
1<=N<=107
1<=A[],B[]<=1018

Example:
Input:
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15

Output:
1
0

Explanation:
Testcase1:
Input : A[] = {1, 2, 5, 4, 0}; B[] = {2, 4, 5, 0, 1};
Output : 1

Testcase2:
Input : A[] = {1, 2, 5}; B[] = {2, 4, 15};
Output : 0
 */

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(myReader.readLine());
        for (int i = 0; i < testCases; i++) {
            String size = myReader.readLine();
            String[] array = myReader.readLine().split(" ");
            String[] otherArray = myReader.readLine().split(" ");
            HashMap<String, Integer> myMap = new HashMap<>();
            boolean failure = false;
            for (String num : array) {
                if (!myMap.containsKey(num)) {
                    myMap.put(num, 1);
                } else {
                    myMap.put(num, myMap.get(num) + 1);
                }
            }
            for (String num : otherArray) {
                if (!myMap.containsKey(num)) {
                    failure = true;
                    break;
                }
                if (myMap.get(num) == 0) {
                    failure = true;
                    break;
                }
                myMap.put(num, myMap.get(num) - 1);
            }
            if (!failure) {
                for (Integer integer : myMap.values()) {
                    if (integer != 0) {
                        failure = true;
                        break;
                    }
                }
            }
            System.out.println(failure ? 0 : 1);

        }
    }
}
