package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.list.ListNode;

/**
 * LCR 021. 删除链表的倒数第 N 个结点
 *
 * @author mihone
 * @since 2025/5/7 21:51
 */
public class LCR021 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //-1 1 2 3 4
        // 5
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode pre = null;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (pre != null) {

            pre.next = slow.next;
        }
        return dummy.next;

    }
}
