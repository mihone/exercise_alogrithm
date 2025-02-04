package com.exercise.algorithm.hot100.list;

import com.exercise.algorithm.base.list.DLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author mihone
 * @since 2025/2/3 20:38
 */
public class LRUCache {


    private Map<Integer, DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        removeNode(dLinkedNode);
        add2Last(dLinkedNode);

        return dLinkedNode.value;

    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode == null) {
            dLinkedNode = new DLinkedNode(key, value);
            add2Last(dLinkedNode);
            map.put(key, dLinkedNode);
        } else {
            removeNode(dLinkedNode);
            add2Last(dLinkedNode);
            dLinkedNode.value = value;
        }
        if (map.size() > capacity) {
            DLinkedNode next = head.next;
            removeNode(next);
            map.remove(next.key);
        }

    }

    private void removeNode(DLinkedNode dLinkedNode) {
        dLinkedNode.prev.next = dLinkedNode.next;
        dLinkedNode.next.prev = dLinkedNode.prev;

    }

    private void add2Last(DLinkedNode dLinkedNode) {
        DLinkedNode prev = tail.prev;
        prev.next = dLinkedNode;
        tail.prev = dLinkedNode;
        dLinkedNode.next = tail;
        dLinkedNode.prev = prev;


    }

}
