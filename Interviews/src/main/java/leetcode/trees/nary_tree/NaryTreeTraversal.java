package leetcode.trees.nary_tree;

import java.util.*;

/**
 * Preorder Traverse ->Input: root = [1,null,3,2,4,null,5,6],  Output: [1,3,5,6,2,4]
 */
public class NaryTreeTraversal {

    // Iterative O(N)

    /**
     * Time complex->O(N), Space complexity->O(N)
     */
    class  PreOrderTraversal {
       public List<Integer> preorderIterative(Node root) {
           LinkedList<Node> stack = new LinkedList<>();
           LinkedList<Integer> result = new LinkedList<>();
           if (root == null) {
               return result;
           }

           stack.add(root);
           while (!stack.isEmpty()) {
               Node node = stack.pollLast();
               result.add(node.val);
               Collections.reverse(node.children);
               for (Node item : node.children) {
                   stack.add(item);
               }
           }
           return result;
       }
    }
    class PostOrderTraversal{
        public List<Integer> postorderIterative(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                result.addFirst(node.val);
                for (Node item : node.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }
            }
            return result;
        }
    }

    class LevelOrderTraversal{

        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrderRecursion(Node root) {
            if (root != null)
                traverseNode(root, 0);
            return result;
        }

        private void traverseNode(Node node, int level) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            for (Node child : node.children) {
                traverseNode(child, level + 1);
            }
        }

        public List<List<Integer>> levelOrderBreadFirst(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            List<Node> previousLayer = Arrays.asList(root);

            while (!previousLayer.isEmpty()) {
                List<Node> currentLayer = new ArrayList<>();
                List<Integer> previousVals = new ArrayList<>();
                for (Node node : previousLayer) {
                    previousVals.add(node.val);
                    currentLayer.addAll(node.children);
                }
                result.add(previousVals);
                previousLayer = currentLayer;
            }

            return result;
        }

        public List<List<Integer>> levelOrderBreadFirstUsingQueue(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.val);
                    queue.addAll(node.children);
                }
                result.add(level);
            }
            return result;
        }
    }
}
