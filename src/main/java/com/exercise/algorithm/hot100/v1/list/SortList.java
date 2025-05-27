package com.exercise.algorithm.hot100.v1.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 148. 排序链表
*  @author mihone
*  @since 2025/2/3 20:29
*/
public class SortList {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(rightHead);
        ListNode listNode = mergeTwoLists(l1, l2);
        return listNode;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode  dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }else {
            cur.next = list2;
        }
        return dummy.next;

    }
}
