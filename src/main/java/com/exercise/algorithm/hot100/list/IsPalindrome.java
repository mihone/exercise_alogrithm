package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 234. 回文链表
 *
 * @author mihone
 * @since 2025/2/3 18:26
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);
        while (newHead != null && head!=null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head) {

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
}
