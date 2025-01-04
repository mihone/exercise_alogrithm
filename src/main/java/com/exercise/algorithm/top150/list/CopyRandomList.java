package com.exercise.algorithm.top150.list;

import com.exercise.algorithm.base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 *
 * @author mihone
 * @since 2024/12/15 10:23
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> old2NewMap = new HashMap<Node, Node>();
        Node oldCur = head;
        while (oldCur != null) {
            old2NewMap.put(oldCur, new Node(oldCur.val));
            oldCur = oldCur.next;
        }
        oldCur = head;
        while (oldCur != null) {
            old2NewMap.get(oldCur).next = old2NewMap.get(oldCur.next);
            old2NewMap.get(oldCur).random = old2NewMap.get(oldCur.random);
            oldCur = oldCur.next;
        }
        return old2NewMap.get(head);
    }
}
