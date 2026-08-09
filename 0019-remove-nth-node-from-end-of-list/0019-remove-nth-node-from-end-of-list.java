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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        //base case
        if (count == n) {
            return head.next;
        }

        ListNode prev = null;
        curr = head;

        int steps = 1;
        while (steps <= count-n) {
            prev = curr;
            curr = curr.next;
            steps++;
        }
        prev.next = curr.next;

        return head;
    }
}