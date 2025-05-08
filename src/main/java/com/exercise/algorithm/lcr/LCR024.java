package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.list.ListNode;

/**
 * LCR 024. 反转链表
*  @author mihone
*  @since 2025/5/8 21:22
*/
public class LCR024 {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;


    }

    public static void main(String[] args) {

    }
}
