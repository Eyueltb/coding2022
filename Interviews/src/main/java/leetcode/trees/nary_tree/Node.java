package leetcode.trees.nary_tree;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
