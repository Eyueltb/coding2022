package leetcode.trees.binary_tree;

public class CountUniValueSubtrees {
    int count = 0;

    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null)
            return true;

        // check if node.left and node.right are uniValue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val))
            return false;

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a uniValue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }
    public int countUniValSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
}
