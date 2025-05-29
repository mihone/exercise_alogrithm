package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.ListNode;
/**
 * [ENHANCE]
*  @author mihone
*  @since 2025/5/29 20:03
*/
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
        } while (slow != fast);

        if (slow == null) {
            return null;
        }

        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;


    }
}
