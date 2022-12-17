package leetcode.tries;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 *
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 */

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
   public Trie() {
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) { //loop through input
            char c = word.charAt(i);// get char
            if(curr.children.get(c) == null) {// if no child
                // no children -> insert a new node if the path does not exist
                curr.children.put(c, new TrieNode());// create new child
            }
            curr = curr.children.get(c); // get the next char
        }
        curr.isWord = true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children.get(c) == null) {
                return  false;
            }
            curr = curr.children.get(c); //find the next char
        }
        return true;
    }
    String longestPrefix(String word) {
        TrieNode curr = root;
        String s = "";
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children.get(c) == null) {
                return s;
            }
            s+=c;
            curr = curr.children.get(c);
        }
        return word;
    }
    @Data
    private class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> children = new HashMap<>();
    }

}
