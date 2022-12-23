package leetcode.trees.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 *  Algorithm
 *  1. Build a hashmap to record the relation of value -> index for inorder,
 *  so that we can find the position of root in constant time.
 *  2. Initialize an integer variable preorderIndex to keep track of the element
 *  that will be used to construct the root
 *  3. Implement the recursion function arrayToTree which takes a range of inorder and
 *  returns the constructed binary tree:
 *      3.1 if the range is empty, return null;
 *      3.2 initialize the root with preorder[preorderIndex] and then increment preorderIndex;
 *      3.3 recursively use the left and right portions of inorder to construct the left and right subtrees.
 *  4. Simply call the recursion function with the entire range of inorder.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
