package com.exercise.algorithm.hot100.v2.list;

import com.exercise.algorithm.base.list.DLinkedNode;
import com.exercise.algorithm.base.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;

    DLinkedNode head;
    DLinkedNode tail;

    Map<Integer, DLinkedNode> map = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        remove(dLinkedNode);
        add2First(dLinkedNode);
        return dLinkedNode.value;

    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode == null) {
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            add2First(node);
            if (map.size() > capacity) {
                DLinkedNode p = tail.prev;
                map.remove(p.key);
                remove(p);
            }
        } else {
            dLinkedNode.value = value;
            remove(dLinkedNode);
            add2First(dLinkedNode);

        }

    }


    public void add2First(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;

    }

    public void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}
