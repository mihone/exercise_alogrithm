package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * [ENHANCE]
 * 19. 删除链表的倒数第 N 个结点
*  @author mihone
*  @since 2025/2/3 20:11
*/
public class RemoveNthFromEnd {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;

        }
        slow.next = slow.next.next;
        return dummy.next;

    }
}
