class TrieNode {
    // Initialize your data structure here.
    private static final int R = 26;
    public char c;
    public int val;
    public TrieNode[] next;
    public TrieNode() {
        this.next = new TrieNode[R];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        insert(word, root, 0);
    }
    
    private TrieNode insert(String word, TrieNode root, int index) {
        if(root == null) {
            root = new TrieNode();
        }
        if (index == word.length()) {
            root.val = 1;
            return root; 
        }
        char c = word.charAt(index);
        root.next[c - 'a'] = insert(word, root.next[c - 'a'], index + 1);
        return root;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode x = search(word, root, 0);
        if (x != null && x.val == 1) return true;
        return false;
    }
    
    private TrieNode search(String word, TrieNode root, int index) {
        if (root == null) return null;
        else if (index == word.length()) return root;
        char c = word.charAt(index);
        return search(word, root.next[c - 'a'], index + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return true;
        TrieNode x = search(prefix, root, 0);
        if(x != null) return true;
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");