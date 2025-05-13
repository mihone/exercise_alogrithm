package com.exercise.algorithm.lcr;

import com.exercise.algorithm.base.list.Node;

/**
 * [ENHANCE]
 * LCR 029. 循环有序列表的插入
 *
 * @author mihone
 * @since 2025/5/12 21:10
 */
public class LCR029 {
    public static void main(String[] args) {
        LCR029 lcr029 = new LCR029();
        System.out.println(lcr029.insert(new Node(1),0));
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node node = new Node(insertVal);
        //注意给定的链表就是环
        if (head.next == head) {
            node.next = head;
            head.next = node;
            return head;
        }
        Node curr = head, next = head.next;
        //循环条件解决链表中的元素都一样的问题
        while (next != head) {
            //中间的情况
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            //头尾的情况
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;



    }
}
