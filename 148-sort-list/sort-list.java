class Solution {

    public ListNode sortList(ListNode head) {

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // split list into two halves
        ListNode mid = getMid(head);

        ListNode rightHead = mid.next;
        mid.next = null;

        // recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // merge sorted halves
        return merge(left, right);
    }

    // find middle node
    private ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }
}