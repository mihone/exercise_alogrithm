package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }else if (l2 == null) {
                current.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            } else {
                current.next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (carry!=0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;

    }
}
