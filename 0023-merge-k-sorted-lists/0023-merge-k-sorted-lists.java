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
    public ListNode mergeKLists(ListNode[] lists) {
        // Min heap comparing nodes by their value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        // Dummy head for result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            // Smallest node
            ListNode min = pq.poll();
            tail.next = min;
            tail = tail.next;

            // If this node has a next, push it into the heap
            if (min.next != null) pq.offer(min.next);
        }

        return dummy.next;
    }
}
