/* Return reference of new head of the reverse linked list 
 class Node {
     int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
} 
Given a linked list of N nodes. The task is to reverse this list.

Input:
First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the elements of linked list.

Output:
Reverse the linked list and return head of the modified list.

User Task:
The task is to complete the function reverseList() which head reference as the only argument and should return new head after reversing the list.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
6
1 2 3 4 5 6
5
2 7 8 9 10

Output:
6 5 4 3 2 1
10 9 8 7 2

Explanation:
Testcase 1: After reversing the list, elements are as 6->5->4->3->2->1.

*/
class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
       Node previous=null;
       Node next=head.next;
       Node current=head;
       while(current!=null){
           next=current.next;
           current.next=previous;
           previous=current;
           current=next;
       }
       return previous;
          
   }
}
