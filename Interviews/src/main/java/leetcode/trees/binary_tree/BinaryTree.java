package leetcode.trees.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Traverse A Tree
 * preorder, inorder and postorder traversal recursively and iteratively
 * level traversal using BFS.
 * Preorder(CLR) traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
 * In-order(LCR) traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.
 * Post-order(LRC) traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.
 * post-order is widely use in mathematical expression
 *
 *
 * Given the root of a binary tree, return the preorder traversal, inorder and post order of its nodes' values.
 *   Input: root = [1,null,2,3], root = [], root = [1]
 *   Output: preorder [1,2,3], [], [1] respectively
 *   Output: inorder [3,2,1], [], [1] respectively
 *   Output: postorder [1,3,2], [], [1] respectively
 *
 *   Constraints:
 *   The number of nodes in the tree is in the range [0, 100].
 *   -100 <= Node.val <= 100
 */

public class BinaryTree {
    private TreeNode root;
    public BinaryTree() {
        root = new TreeNode();
    }

    /**
     * Given the root of a binary tree, return the preorder traversal of its nodes' values.
     * Algorithm
     *      1. Initialize an empty array result.
     *      2. Start with the root node root. If root is not NULL:
     *              add its value to result.
     *              repeat step 2 with root's left child
     *              repeat step 2 with root's right child.
     *      3. Return answer after the iteration stops.
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversal(root, results);
        return results;
    }
    private void preorderTraversal(TreeNode root, List<Integer> results) {
        if (root == null)
            return;

        results.add(root.val); // visit root
        preorderTraversal(root.left, results);   // traverse left subtree
        preorderTraversal(root.right, results);  // traverse right subtree
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();//for storage
        inorderTraversal(root, results);
        return results;
    }
    private void inorderTraversal(TreeNode root, List<Integer> results) {
        if (root == null)
            return;
        inorderTraversal(root.left, results);   // traverse left subtree
        results.add(root.val);                  // visit the root
        inorderTraversal(root.right, results);  // traverse right subtree
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postorderTraversal(root, results);
        return results;
    }
    private void postorderTraversal(TreeNode root, List<Integer> results) {
        if (root == null)
            return;
        postorderTraversal(root.left, results);   // traverse left subtree
        postorderTraversal(root.right, results);  // traverse right subtree
        results.add(root.val);                    // visit the root
    }

    public List<Integer> preorderIterativeTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root != null) {
            s.push(root);
        }
        TreeNode cur;
        while (!s.empty()) {
            cur = s.pop();
            results.add(cur.val);    // visit the root
            if (cur.right != null) {
                s.push(cur.right);  // push right child to stack if it is not null
            }
            if (cur.left != null) {
                s.push(cur.left);  // push left child to stack if it is not null
            }
        }
        return results;
    }

}





