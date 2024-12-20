package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author mihone
 * @since 2024/12/15 11:06
 */
public class DeleteDuplicates {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }
            if (next.val != cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            }

        }
        return dummy.next;
    }
}
