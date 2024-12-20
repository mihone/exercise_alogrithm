package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.ListNode;

/**
 * @author mihone
 * @since 2024/12/15 10:52
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        System.out.println(removeNthFromEnd.removeNthFromEnd(new ListNode(1), 1));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int num = count - n;
        cur = dummy;
        for (int i = 0; i < num; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;

    }
}
