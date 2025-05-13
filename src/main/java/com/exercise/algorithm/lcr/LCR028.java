package com.exercise.algorithm.lcr;


import com.exercise.algorithm.base.lcr.list.Node;

/**
 * LCR 028. 扁平化多级双向链表
 *
 * @author mihone
 * @since 2025/5/12 20:44
 */
public class LCR028 {

    public Node flatten(Node head) {

        Node[] nodes = flattenInternal(head);
        return nodes[0];


    }

    public Node[] flattenInternal(Node head) {
        Node h = head;
        Node current = head;
        Node pre = null;

        while (current != null) {
            Node next = current.next;
            if (current.child != null) {
                Node[] nodes = flattenInternal(current.child);
                current.next = nodes[0];
                nodes[0].prev = current;
                current.child = null;
                if (next != null) {
                    nodes[1].next = next;
                    next.prev = nodes[1];
                }
                pre = nodes[1];
                current = nodes[1].next;
            } else {
                pre = current;
                current = next;
            }
        }
        return new Node[]{h, pre};

    }
}
