package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.ListNode;

public class SwapPairs {


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode forward = next.next;
            cur.next = forward;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = forward;

        }
        return dummy.next;

    }
}
