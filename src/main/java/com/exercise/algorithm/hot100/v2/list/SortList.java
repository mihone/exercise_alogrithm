package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.ListNode;

public class SortList {


    // 1 2
    // 3 4 5
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode pre = null;
        while (fast!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode head2 = pre.next;
        pre.next = null;
        ListNode s1 = sortList(head);
        ListNode s2 = sortList(head2);
        ListNode listNode = mergeTwoList(s1, s2);
        return listNode;

    }



    public ListNode mergeTwoList(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2==null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if (l1 != null) {
            pre.next = l1;
        } else if (l2 != null) {
            pre.next = l2;
        }

        return dummy.next;

    }
}
