package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.ListNode;

/**
*  @author mihone
*  @since 2024/12/15 10:41
*/
public class ReverseBetween {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        int num = right - left;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preHead = null;
        ListNode cur = dummy;
        for (int i = 0; i < left; i++) {
            preHead = cur;
            cur = cur.next;
        }
        ListNode pre = cur;
        for (int i = 0; i < num; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            preHead.next = next;
            next.next = pre;
            pre = next;
        }
        return dummy.next;

    }
}
