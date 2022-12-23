package leetcode.trees.binary_tree;

import lombok.Data;

@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (){ }
    public TreeNode(int val){
        this(val, null, null);
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
