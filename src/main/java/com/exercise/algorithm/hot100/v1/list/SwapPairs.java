package com.exercise.algorithm.hot100.v1.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * [ENHANCE]
 * 24. 两两交换链表中的节点
*  @author mihone
*  @since 2025/2/3 20:18
*/
public class SwapPairs {
    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;

        }
        return dummy.next;

    }
}
