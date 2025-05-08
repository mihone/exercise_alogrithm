package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.list.ListNode;

/**
 * LCR 022. 环形链表 II
 * @author mihone
 * @since 2025/5/8 21:09
 */
public class LCR022 {

    public static void main(String[] args) {

    }

    // a+ b+n(b+c) = 2 (a+b)
    //
    public ListNode detectCycle(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while ((slow == dummy || fast != slow) && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (fast == null) {
            return null;
        }
        ListNode p = dummy;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;

    }
}
