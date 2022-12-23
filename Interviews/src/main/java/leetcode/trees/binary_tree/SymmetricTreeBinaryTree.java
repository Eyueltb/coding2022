package leetcode.trees.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
 * Two trees are a mirror reflection of each other if:
 *      Their two roots have the same value.
 *      The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
 */
public class SymmetricTreeBinaryTree {
    /**
     * Time complexity : O(n) because traversal the entire tree once
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val)
                && isMirror(left.right, right.left)
                && isMirror(left.left, right.right);
    }
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
