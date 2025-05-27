package com.exercise.algorithm.hot100.v1.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 142. 环形链表 II
*  @author mihone
*  @since 2025/2/3 18:36
*/
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        ListNode p = dummy;
        while (slow!=null&& p!=null &&p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return slow;


    }

    public static void main(String[] args) {

    }
}
