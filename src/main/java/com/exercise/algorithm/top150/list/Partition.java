package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.list.ListNode;

/**
 * 86. 分隔链表
*  @author mihone
*  @since 2024/12/15 16:35
*/
public class Partition {

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }



}
