package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.ListNode;
/**
 * [ENHANCE]
*  @author mihone
*  @since 2025/5/29 19:51
*/
public class IsPalindrome {


    //1 2 3 3 2 1
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
            }
        }

        ListNode newHead = pre.next;
        pre.next = null;
        newHead = reverseList(newHead);

        while (newHead!=null&&head!=null){
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;

    }


    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;


    }
}
