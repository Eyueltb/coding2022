package leetcode.trees.binary_tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

    class PreOrderTraversal {
        private List<Integer> result = new ArrayList<>();
        //Recursive
        /**
         * Time & space complexity-O(n)- since we visited each node once
         * Algorithm
         * 1. Initialize an empty array result.
         * 2. Start with the root node root. If root is not NULL:
         *      2.1 add its value to result.
         *      2.2 repeat step 2 with root's left child
         *      2.3 repeat step 2 with root's right child.
         * 3. Return result after the iteration stops.
         */
        public List<Integer> preorderRecursiveTraversal(TreeNode root) {
            dfs(root);
            return result;
        }        private void dfs(TreeNode node) {
            if (node == null) return;
            //visit the root first, then the left subtree, then the right subtree
            result.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
        //Iterative
        /**
         * Algorithm
         * 1. Initialize an empty array result and an empty stack.
         * 2. Add root to stack.
         * 3. While stack is not empty, get the top node currNode from stack. If currNode is not NULL:
         *    3.1 add its value to result.
         *    3.2 add its right child to stack.
         *    3.3 add its left child to stack.
         * Then repeat step 3.
         * 4. Return result after we empty stack.
         */
        public List<Integer> preorderTraversalIterative(TreeNode root) {
            //List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            // Note that we add currNode's right child to the stack first.
            while (!stack.isEmpty()) {
                TreeNode currNode = stack.peek();
                stack.pop();
                if (currNode != null) {
                    result.add(currNode.val);
                    stack.add(currNode.right);
                    stack.add(currNode.left);
                }
            }
            return result;
        }
        //Morris
        public List<Integer> preorderTraversalMorris(TreeNode root) {
            //List<Integer> result = new ArrayList<>();
            TreeNode curr = root, last;

            while (curr != null) {
                // If there is no left child, go for the right child.
                // Otherwise, find the last node in the left subtree.
                if(curr.left == null) {
                    result.add(curr.val);
                    curr = curr.right;
                } else {
                    last = curr.left;
                    while (last.right != null && last.right != curr) {
                        last = last.right;
                    }

                    // If the last node is not modified, we let
                    // 'curr' be its right child. Otherwise, it means we
                    // have finished visiting the entire left subtree.
                    if (last.right == null) {
                        result.add(curr.val);
                        last.right = curr;
                        curr = curr.left;
                    } else {
                        last.right = null;
                        curr = curr.right;
                    }
                }
            }
            return result;
        }
    }

    class InOrderTraversal {
        //Recursive
        /**
         * Algorithm
         * 1. Initialize an empty array result.
         * 2. Start with the root node root. If root is not NULL:
         *      2.1 repeat step 2 with root's left child
         *      2.2 add its value to result.
         *      2.3 repeat step 2 with root's right child.
         * 3. Return result after the iteration stops.
         *
         * Time complexity: O(n) and Space complexity: O(n)
         * The time complexity is O(n) because the recursive function is T(n)=2⋅T(n/2)+1T(n) = 2 T(n/2) + 1T(n) = 2⋅T(n/2)+1.
         */
        public List<Integer> inorderTraversalRecursive(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                helper(root.left, res);
                res.add(root.val);
                helper(root.right, res);
            }
        }
        //Iterative
        public List<Integer> inorderTraversalIterative(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;
        }
        //Morris
        /**
         * Step 1: Initialize current as root
         *
         * Step 2: While current is not NULL,
         *
         * If current does not have left child
         *
         *     a. Add current’s value
         *
         *     b. Go to the right, i.e., current = current.right
         *
         * Else
         *
         *     a. In current's left subtree, make current the right child of the rightmost node
         *
         *     b. Go to this left child, i.e., current = current.left
         */
        public List<Integer> inorderTraversalMorris(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode curr = root;
            TreeNode pre;
            while (curr != null) {
                if (curr.left == null) {
                    res.add(curr.val);
                    curr = curr.right; // move to next right node
                } else { // has a left subtree
                    pre = curr.left;
                    while (pre.right != null) { // find rightmost
                        pre = pre.right;
                    }
                    pre.right = curr; // put cur after the pre node
                    TreeNode temp = curr; // store cur node
                    curr = curr.left; // move cur to the top of the new tree
                    temp.left = null; // original cur left be null, avoid infinite loops
                }
            }
            return res;
        }
    }

    class PostOrderTraversal {
        public List<Integer> postorderTraversalRecursive(TreeNode root) {
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
    }
}
