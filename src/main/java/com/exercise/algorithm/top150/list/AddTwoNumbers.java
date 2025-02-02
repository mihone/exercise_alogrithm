package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 2. 两数相加
 *
 * @author mihone
 * @since 2024/12/15 10:07
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                int val = l2.val + carry;
                cur.next = new ListNode(val % 10);
                carry = val / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                int val = l1.val + carry;
                cur.next = new ListNode(val % 10);
                carry = val / 10;
                l1 = l1.next;
            } else {
                int val = l1.val + carry + l2.val;
                cur.next = new ListNode(val % 10);
                carry = val / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;

    }

}
