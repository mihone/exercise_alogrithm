package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 2. 两数相加
 *
 * @author mihone
 * @since 2025/2/3 20:07
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int sum = l1.val + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l1 = l1.next;
            } else {
                int sum = l2.val + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (carry>0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;

    }
}
