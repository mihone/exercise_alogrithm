package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public Node copyRandomList(Node head) {

        Map<Node, Node> old2NewMap = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            old2NewMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            Node newNode = old2NewMap.get(cur);
            newNode.next = old2NewMap.get(cur.next);
            newNode.random = old2NewMap.get(cur.random);
            cur = cur.next;
        }
        return old2NewMap.get(head);

    }
}
