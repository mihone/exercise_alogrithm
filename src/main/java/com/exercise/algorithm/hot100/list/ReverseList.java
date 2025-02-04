package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.ListNode;

/**
*  @author mihone
*  @since 2025/2/3 18:17
*/
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
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
