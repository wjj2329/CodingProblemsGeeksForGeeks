Given a singly linked list, delete middle  of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

If the input linked list is NULL, then it should remain NULL. If the input linked list has 1 node, then this node should be deleted and new head should be returned.

Input:
First line of input contains number of testcases T. For each testcase, there will be two line of input, first of which contains number of nodes in the linked list and next line contains elements in the nodes of linked list.

Output:
Your function should return head  of the modified linked list.  If linked list is empty then it should return NULL.

User Task:
The task is to complete the function deleteMid() which should delete the middle element from linked list. 

Constraints:
1 <=T<= 50
1 <=N<= 1000
1 <=value<= 1000

Example:
Input:
2
5
1 2 3 4 5
6
2 4 6 7 5 1

Output:
1 2 4 5
2 4 6 5 1

Explanation:
Testcase 1: After deleting middle of the linked list, 3 will be deleted and the list will be as 1, 2, 4, 5.




class GFG
{
   Node Delete(Node head)
   {
       Node leader=head;
       Node middle=head;
       Node previous=head;
       while(leader!=null){
           leader=leader.next;
           if(leader!=null){
                leader=leader.next;
                previous=middle;
                middle=middle.next;
           }
       }
       previous.next=middle.next;
       //System.out.println(previous.data);
      //System.out.println(leader.data);
       return head;
	   // This is method only submission.
           // You only need to complete the method.
   }
}
