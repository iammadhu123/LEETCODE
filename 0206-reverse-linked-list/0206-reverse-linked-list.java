/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //Base case
        if (head == null) {
            return null;
        }
        Stack<ListNode> s = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            s.push(curr);
            curr = curr.next;
        }

        ListNode newHead = s.pop(); // first popped node is new head
        ListNode temp = newHead;

        while (!s.isEmpty()) {
            temp.next = s.pop(); 
            temp = temp.next;
        }

        temp.next = null; 
        return newHead;
    }
}