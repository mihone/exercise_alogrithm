package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.ListNode;

public class RemoveNthFromEnd {


    //1 2 3 4 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode slow = dummy;
        ListNode pre = null;
        while (fast!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (pre!=null) {
            ListNode next = pre.next;
            pre.next = next.next;
            next.next = null;
        }



        return dummy.next;



    }
}
