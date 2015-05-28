public class WordDictionary {
    private static int R=26;
    private Node root;
    
    private class Node{
        private int val;
        private Node[] next;
        public Node(){
            val=0;
            next=new Node[26];
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word==null||word.length()==0) return;
        root=addWord(root,word,0);
    }
    private Node addWord(Node x,String word,int index){
        if(x==null) x=new Node();
        if(index==word.length()){
            x.val=1;
            return x;
        }
        char c=word.charAt(index);
        x.next[c-'a']=addWord(x.next[c-'a'],word,index+1);
        return x;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Node x=search(root,word,0);
        if(x==null||x.val!=1) return false;
        return true;
    }
    private Node search(Node x,String word,int index){
        if(x==null) return null;
        if(index==word.length()) return x;
        char c=word.charAt(index);
        if(c=='.'){
            for(int i=0;i<R;i++){
                Node res=search(x.next[i],word,index+1);
                if(res!=null&&res.val==1) return res;
            }
            return null;
        }
        return search(x.next[c-'a'],word,index+1);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");