package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.ListNode;

/**
 * 141. 环形链表
 *
 * @author mihone
 * @since 2024/12/15 9:55
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && (fast != slow || fast == dummy)) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow == fast;

    }
}
