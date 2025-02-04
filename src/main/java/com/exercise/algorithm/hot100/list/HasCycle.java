package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 141. 环形链表
 * @author mihone
 * @since 2025/2/3 18:32
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;


    }
}
