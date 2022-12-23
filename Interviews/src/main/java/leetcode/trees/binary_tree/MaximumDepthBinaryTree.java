package leetcode.trees.binary_tree;

import java.util.LinkedList;

public class MaximumDepthBinaryTree {
    /**
     * Intuition By definition, the maximum depth of a binary tree is the
     * maximum number of steps to reach a leaf node from the root node.
     *
     * From the definition, an intuitive idea would be to traverse the tree
     * and record the maximum depth during the traversal.
     * One could traverse the tree either by Depth-First Search (DFS) strategy
     * or Breadth-First Search (BFS) strategy. For this problem, either way would do.
     * Here the solution is implemented with the DFS strategy and recursion.
     */
    public int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepthRecursion(root.left);
            int right_height = maxDepthRecursion(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    /**
     * Algorithm
     * The idea is to keep the next nodes to visit in a stack.
     * Due to the FILO behavior of stack, one would get the order of visit same as the one in recursion.
     * We start from a stack which contains the root node and the corresponding depth which is 1.
     * Then we proceed to the iterations: pop the current node out of the stack and push the child nodes.
     * The depth is updated at each step.
     */
    public int maxDepthIteration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
}
