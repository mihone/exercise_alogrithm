package com.exercise.algorithm.top150.graph;


import com.exercise.algorithm.base.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 133. 克隆图
 *
 * @author mihone
 * @since 2025/1/4 19:22
 */
public class CloneGraph {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.neighbors = new ArrayList<>();
        root.neighbors.add(new Node(2));
        root.neighbors.add(new Node(4));
        Node root2 = root.neighbors.get(0);
        Node root4 = root.neighbors.get(1);
        root2.neighbors = new ArrayList<>();
        root2.neighbors.add(root);
        Node root3 = new Node(3);
        root2.neighbors.add(root3);
        root3.neighbors = new ArrayList<>();
        root3.neighbors.add(root2);
        root3.neighbors.add(root4);

        root4.neighbors = new ArrayList<>();
        root4.neighbors.add(root);
        root4.neighbors.add(root3);
        CloneGraph cloneGraph = new CloneGraph();
        Node node = cloneGraph.cloneGraph(root);
        System.out.println();

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (node.neighbors == null || node.neighbors.isEmpty()) {
            Node node1 = new Node();
            node1.val = node.val;
            return node1;
        }

        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, Node> half = new HashMap<>();
        dfs(map, half, node);
        return map.get(1);

    }

    private void dfs(Map<Integer, Node> map, Map<Integer, Node> half, Node node) {
        Node n = map.get(node.val);
        if (n != null) {
            return;
        }
        n = half.get(node.val);
        if (n == null) {
            n = new Node();
            n.val = node.val;
            half.put(n.val, n);
        }
        n.neighbors = new ArrayList<>();
        if (node.neighbors != null && !node.neighbors.isEmpty()) {
            for (Node neighbor : node.neighbors) {
                if (map.get(neighbor.val) != null) {
                    n.neighbors.add(map.get(neighbor.val));
                } else if (half.get(neighbor.val) != null) {
                    n.neighbors.add(half.get(neighbor.val));
                } else {
                    Node ne = new Node();
                    ne.val = neighbor.val;
                    n.neighbors.add(ne);
                    half.put(ne.val, ne);
                }
            }
        }
        map.put(n.val, n);
        half.remove(n.val);
        if (node.neighbors != null && !node.neighbors.isEmpty()) {
            for (Node neighbor : node.neighbors) {
                dfs(map, half, neighbor);
            }
        }
    }
}
