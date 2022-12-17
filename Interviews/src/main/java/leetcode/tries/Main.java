package leetcode.tries;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
        System.out.println(trie.longestPrefix("apple1"));
        System.out.println(trie.longestPrefix("app"));
    }
}

