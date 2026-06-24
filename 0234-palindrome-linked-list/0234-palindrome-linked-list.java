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
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode middle(ListNode head)
    {
       ListNode slow = head;
       ListNode fast = head;

       while(fast.next != null && fast.next.next != null)
       {
        slow = slow.next;
        fast = fast.next.next;
       }return slow;

    }
    public boolean isPalindrome(ListNode head) {
         if(head == null || head.next == null)
        {
            return true;
        }
        ListNode middle = middle(head);
        ListNode secondHalf = reverse(middle.next);
        ListNode firstHalf = head;
        while(secondHalf != null)
        {
        if(firstHalf.val != secondHalf.val)
        {
            return false;
        }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;  
        }
        return true; 
    }    
}