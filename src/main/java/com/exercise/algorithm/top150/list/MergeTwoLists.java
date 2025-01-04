package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.ListNode;

/**
 * 21. 合并两个有序链表
*  @author mihone
*  @since 2024/12/15 10:13
*/
public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) {
            return list2;
        }
        if (list2==null) {
            return list1;
        }
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;

            }
            if (list1==null){
                curr.next = list2;
            }
            else {
                curr.next = list1;
            }
        }
        return dummy.next;

    }


}
