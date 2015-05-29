public class Solution {
    private TrieNode root;
    private int[] directionX={1,-1,0,0};
    private int[] directionY={0,0,1,-1};
    private boolean[][] marked;
    
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res=new HashSet<String>();
        if(board==null||board.length==0||board[0].length==0||words==null||words.length==0) return new ArrayList<String>();
        for(String word:words)
            insert(word);
        marked=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!marked[i][j]&&startsWith(""+board[i][j]))
                    dfs(board,i,j,""+board[i][j],res);
            }
        }
        return new ArrayList<String>(res);
    }
    
    private void dfs(char[][] board,int i,int j,String item,HashSet<String> res){
        if(search(item)){
            res.add(item);
        }
        marked[i][j]=true;
        for(int[] t:neighbor(board,i,j)){
            int x=t[0];
            int y=t[1];
            char c=board[x][y];
            if(!marked[x][y]&&startsWith(item+c)){
                dfs(board,x,y,item+c,res);
            }
        }
        marked[i][j]=false;
    }
    
    private Iterable<int[]> neighbor(char[][] board,int i,int j){
        ArrayList<int[]> res=new ArrayList<int[]>();
        for(int k=0;k<directionX.length;k++){
            int x=i+directionX[k];
            int y=j+directionY[k];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length){
                int[] temp={x,y};
                res.add(temp);
            }
        }
        return res;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null||word.length()==0) return;
        root=insert(root,word,1,0);
    }
    
    //insert word along with val=1 to jugde whether it is a word or not
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
    
    private class TrieNode {
        public TrieNode[] next;
        public int val;
        // Initialize your data structure here.
        public TrieNode() {
            next=new TrieNode[26]; 
            val=0;
        }
    }
}