package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 61. 旋转链表
*  @author mihone
*  @since 2024/12/15 14:14
*/
public class RotateRight {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int total = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            total++;
        }
        k = k % total;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;
        int num = total - k;
        for (int i = 0; i < num; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = dummy.next;
        return newHead;

    }
}
