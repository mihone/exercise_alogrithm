package com.exercise.algorithm.hot100.v1.list;

import com.exercise.algorithm.base.list.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
*  @author mihone
*  @since 2025/2/3 20:26
*/
public class CopyRandomList {

    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }
}
