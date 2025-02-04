package com.exercise.algorithm.base.graph;

import java.util.List;

public class Node {

    public int val;
    public List<Node> neighbors;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

}
