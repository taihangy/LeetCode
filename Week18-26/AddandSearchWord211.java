public class WordDictionary {
    // using Trie, summary respectively 
    private static final int R = 26;
    private TrieNode root = new TrieNode();
    
    private class TrieNode {
        private int val;
        private TrieNode[] next;
        public TrieNode() {
            this.val = 0;
            this.next = new TrieNode[R];
        }
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        // check parameter
        if(word == null || word.length() == 0) return;
        addWord(root, word, 1, 0);
    }
    
    // Add a word into Tries
    private TrieNode addWord(TrieNode root, String word, int val, int index) {
        if(root == null) root = new TrieNode();
        if(index == word.length()) {
            root.val = val;
            return root;
        }
        char c = word.charAt(index);
        root.next[c - 'a'] = addWord(root.next[c - 'a'], word, val, index + 1);
        return root;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode x = search(root, word, 0);
        if(x != null && x.val == 1) return true;
        return false;
    }
    
    private TrieNode search(TrieNode root, String word, int index) {
        if(root == null) return null;
        if(index == word.length()) return root;
        char c = word.charAt(index);
        if(c == '.') {
            for(int i = 0; i < R; i++) {
                TrieNode x = search(root.next[i], word, index + 1);
                if(x != null && x.val == 1) return x;
            }
            return null;
        }
        return search(root.next[c - 'a'], word, index + 1);
    }

    // using HashMap, will be faster
    HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        int length = word.length();
        if(!map.containsKey(length)) {
            List<String> list = new ArrayList<String>();
            list.add(word);
            map.put(length, list);
        } else {
            List<String> list = map.get(length);
            list.add(word);
            map.put(length, list);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        int length = word.length();
        if(!map.containsKey(length)) return false;
        List<String> list = map.get(length);
        for(String s : list) {
           if(isSame(word, s)) return true; 
        }
        return false;
    }
    
    private boolean isSame(String word, String s) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) return false;
        }
        return true;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");