package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.list.ListNode;

/**
 * LCR 023. 相交链表
*  @author mihone
*  @since 2025/5/8 21:18
*/
public class LCR023 {

    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;

        }
        return a;

    }
}
