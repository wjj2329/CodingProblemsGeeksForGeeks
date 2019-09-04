import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
*/

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(scan.readLine());
        for (int i = 0; i < testCases; i++) {

            String line = scan.readLine();
            String[] words = line.split("\\.");
            for (int x = words.length - 1; x >= 0; x--) {
                System.out.print(words[x]);
                if (x != 0) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }
}

