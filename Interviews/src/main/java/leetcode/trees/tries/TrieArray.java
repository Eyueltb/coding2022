package leetcode.trees.tries;

import lombok.Data;

/**
 * Complexity Analysis
 *
 * Time complexity : O(m)
 *
 * Space complexity : O(1)
 */
@Data
public class TrieArray {
    private TrieNode root = new TrieNode();
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!currNode.containsKey(currChar)) {
                currNode.put(currChar, new TrieNode());
            }
            currNode = currNode.get(currChar);
        }
        currNode.setEnd();
    }
    // search a prefix or whole key in trie and returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currNode.containsKey(currChar)) {
                currNode = currNode.get(currChar);
            } else {
                return null;
            }
        }
        return currNode;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    String longestPrefix(String word) {
        TrieNode currNode = root;
        String s = "";
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!currNode.containsKey(c)) {
                return s;
            }
            currNode = currNode.get(c);
            s+=c;
        }
        return s;
    }

    @Data
    private class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch-'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch-'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
    }

}
