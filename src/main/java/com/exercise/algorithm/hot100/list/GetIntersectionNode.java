package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * [REPEAT]
 * 160. 相交链表
*  @author mihone
*  @since 2025/2/3 17:58
*/
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }

    public static void main(String[] args) {

    }
}
