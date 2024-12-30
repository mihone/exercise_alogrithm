package com.exercise.algorithm.top150.tree;

import com.exercise.algorithm.base.base2.Node;

import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @author mihone
 * @since 2024/12/28 21:08
 */
public class Connect {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        int count = 1;
        queue.offer(root);
        while (true) {
            int next = 0;
            for (int i = 0; i < count; i++) {
                Node poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (i != count - 1) {
                    Node peek = queue.peek();
                    poll.next = peek;
                }
                if (poll.left != null) {
                    next++;
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    next++;
                    queue.offer(poll.right);
                }
            }
            count = next;
            if (queue.isEmpty()) {
                break;
            }
        }
        return root;
    }
}
