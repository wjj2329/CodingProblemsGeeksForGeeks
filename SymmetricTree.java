/*Given a Binary Tree of size N, your task is to complete the function isSymettric(), that check whether a binary is Symmetric or not, i.e. the binary tree is Mirror image of itself or not.
For example:
The following binary tree is symmetric:

        1
      /   \
    2       2
  /   \   /   \
 3     4 4     3


But the following is not:

       1
     /   \
    2      2
     \      \
      3      3

Input:

The function takes a single argument as input, the root node of the binary tree. There will be T test cases and for each test case the function will be called separately. 
 

Output:
For each testcase the function should return a boolean value.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
3
1 1
1 2 L 1 2 R 0
2 1
10 20 R 10 20 L 20 30 R 5
2 2
10 20 R 10 20 L 10 20 R 10 20 L 20 30 L 100 

Output:
True
False
True

Explanation:
TestCase 1:

             0
           /   \
          1     1
         /       \
        2         2

Tree is mirror image of itself i.e. tree is symmetric

TestCase 2:

             5
          /    \
        10      20
      /    \      \
    20     20      30 

Tree is not mirror image of itself i.e. tree is not symmetric

TestCase 3:

              100
            /     \
          10       10
         /   \    /   \
       20     20 20    20

Tree is mirror image of itself i.e. tree is symmetric

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.*/

import java.util.HashMap;
import java.util.Scanner;

{

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right;
    }
}

class Symmetric_Tree {
    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node child;
        int t = sc.nextInt();

        while (t-- > 0) {
            int N1 = sc.nextInt();
            int N2 = sc.nextInt();
            Node root1 = null;
            Node root2 = null;
            Node root = null;

            HashMap<Integer, Node> hm = new HashMap<Integer, Node>();

            for (int i = 0; i < N1; i++) {
                Node parent = null;
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char c = sc.next().charAt(0);
                if (hm.containsKey(n1) == false) {
                    parent = new Node(n1);
                    hm.put(n1, parent);
                    if (root1 == null)
                        root1 = parent;
                } else
                    parent = hm.get(n1);
                child = new Node(n2);
                if (c == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                hm.put(n2, child);
            }
            hm.clear();

            for (int i = 0; i < N2; i++) {
                Node parent = null;
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char c = sc.next().charAt(0);
                if (hm.containsKey(n1) == false) {
                    parent = new Node(n1);
                    hm.put(n1, parent);
                    if (root2 == null)
                        root2 = parent;
                } else
                    parent = hm.get(n1);
                child = new Node(n2);
                if (c == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                hm.put(n2, child);
            }
            int N = sc.nextInt();
            root = new Node(N);
            root.left = root1;
            root.right = root2;

            GfG gfg = new GfG();
            if (gfg.isSymmetric(root) == true)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }

}

/*This is a function problem.You only need to complete the function given below*/

/*
class of the node of the tree is as
class Node
{
	int key;
	 Node left, right;
	 
	 Node(int data)
	 {
	     key = data;
	     left = right = null
	 }
}
*/
// complete this function
// return true/false if the is Symmetric or not
class GfG {
    public static boolean isMirror = true;

    public static boolean check(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null) {
            isMirror = false;
            return false;
        }
        if (left.data != right.data) {
            //System.out.println(left.data+" "+right.data);
            isMirror = false;
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);

    }

    public static boolean isSymmetric(Node root) {
        isMirror = true;
        check(root, root);
        return isMirror;
    }
}
