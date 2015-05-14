class TrieNode {
    public TrieNode[] next;
    public int val;
    // Initialize your data structure here.
    public TrieNode() {
        next=new TrieNode[26]; 
        val=0;
    }
    
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null||word.length()==0) return;
        root=insert(root,word,1,0);
    }
    
    private TrieNode insert(TrieNode x,String word,int val,int d){
        if(x==null) x=new TrieNode();
        if(d==word.length()){
            x.val=val;
            return x;
        }
        char c=word.charAt(d);
        x.next[c-'a']=insert(x.next[c-'a'],word,val,d+1);
        return x;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode x=search(root,word,0);
        if(x==null) return false;
        else if(x.val!=1) return false;
        return true;
    }
    
    private TrieNode search(TrieNode x,String word,int d){
        if(x==null) return null;
        if(d==word.length()) return x;
        char c=word.charAt(d);
        return search(x.next[c-'a'],word,d+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode x=search(root,prefix,0);
        if(x==null) return false;
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");