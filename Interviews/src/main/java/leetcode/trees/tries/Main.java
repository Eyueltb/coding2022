package leetcode.trees.tries;


import java.util.HashMap;

public class Main {
    //Map sum using brute force
    HashMap<String, Integer> map = new HashMap<>();
    public void insert(String key, int val) {
        map.put(key, val);
    }
    public int sum(String prefix) {
        int result = 0;
        for (String key: map.keySet()) {
            if (key.startsWith(prefix)) {
                result += map.get(key);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
        System.out.println("longest prefix of apple1-> "+ trie.longestPrefix("apple1"));
        System.out.println("longest prefix of app-> "+ trie.longestPrefix("app"));

        TrieArray trieArray = new TrieArray();
        trieArray.insert("apple");
        System.out.println(trieArray.search("apple"));   // return True
        System.out.println(trieArray.search("app"));     // return False
        System.out.println(trieArray.startsWith("app")); // return True
        trieArray.insert("app");
        System.out.println(trieArray.search("app"));     // return True
        System.out.println(trieArray.longestPrefix("app"));
        System.out.println(trieArray.longestPrefix("appleb"));

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
        m.insert("apple", 3);
        System.out.println(m.sum("ap"));           // return 3 (apple = 3)
        m.insert("app", 2);
        System.out.println(m.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)


    }

}
