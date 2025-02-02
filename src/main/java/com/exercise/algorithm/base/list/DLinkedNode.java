package com.exercise.algorithm.base.list;
/**
*  @author mihone
*  @since 2024/12/15 16:41
*/
public class DLinkedNode {
    public int key;
    public int value;
    public DLinkedNode prev;
    public DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int _key, int _value) {
        key = _key;
        value = _value;
    }


}
