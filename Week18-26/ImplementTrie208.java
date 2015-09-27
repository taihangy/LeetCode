/** summary respectively*/
class TrieNode {
    // Initialize your data structure here.
    public int val;
    public TrieNode[] next;
    
    public TrieNode() {
        this.val = val;
        this.next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        insert(root, word, 1, 0);
    }
    
    private TrieNode insert(TrieNode root, String word, int val, int index) {
        if(root == null) root = new TrieNode();
        if(index == word.length()) {
            root.val = val;
            return root;
        }
        char c = word.charAt(index);
        root.next[c - 'a'] = insert(root.next[c - 'a'], word, val, index + 1);
        return root;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode x = search(root, word, 0);
        if(x != null && x.val != 0) return true;
        return false;
    }
    
    private TrieNode search(TrieNode root, String word, int index) {
        if(root == null) return null;
        if(index == word.length()) return root;
        char c = word.charAt(index);
        return search(root.next[c - 'a'], word, index + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return true;
        TrieNode x = search(root, prefix, 0);
        if(x != null) return true;
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");