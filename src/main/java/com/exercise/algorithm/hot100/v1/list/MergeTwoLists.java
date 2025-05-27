package com.exercise.algorithm.hot100.v1.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 21. 合并两个有序链表
*  @author mihone
*  @since 2025/2/3 20:05
*/
public class MergeTwoLists {

    public static void main(String[] args) {

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
