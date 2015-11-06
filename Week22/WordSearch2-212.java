public class Solution {
    //TLE, backtracing cannot stop early with hashset because we can know the prefix of the words, unless we add all the prefix to hashset
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || 
           words == null || words.length == 0) return res;
        Set<String> wordSet = new HashSet<>();
        int maxLen = 0;
        for(String word : words) {
            wordSet.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[][] marked = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(res, marked, board, wordSet, "", i, j, maxLen);
            }
        }
        return res;
    }
    
    private boolean dfs(List<String> res, boolean[][] marked, char[][] board, 
                     Set<String> wordSet, String path, int i, int j, int maxLen) {
        if(res.size() == wordSet.size()) return true;
    	path += board[i][j];
    	if(path.length() > maxLen) return false;
        if(wordSet.contains(path)) {
            res.add(path);
            return false;
        }
        marked[i][j] = true;
        if(i - 1 > 0 && !marked[i - 1][j]) {
            if(dfs(res, marked, board, wordSet, path, i - 1, j, maxLen)) return true;
        }
        if(i + 1 < board.length && !marked[i + 1][j]) {
            if(dfs(res, marked, board, wordSet, path, i + 1, j, maxLen)) return true;
        }
        if(j - 1 > 0 && !marked[i][j - 1]) {
            if(dfs(res, marked, board, wordSet, path, i, j - 1, maxLen)) return true;
        }
        if(j + 1 < board[0].length && !marked[i][j + 1]) {
            if(dfs(res, marked, board, wordSet, path, i, j + 1, maxLen)) return true;
        }
        marked[i][j] = false;
        return false;
    }
}

public class Solution {
    private TrieNode root;
    private static int[] dirX = {1, -1, 0, 0};
    private static int[] dirY = {0, 0, 1, -1};
    private boolean[][] marked;
    
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        if(board == null || board.length == 0 || board[0].length == 0 || 
           words == null || words.length == 0) return new ArrayList<String>();
        marked = new boolean[board.length][board[0].length];
        for(String word : words) {
            insert(word);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                String path = "" + board[i][j];
                if(!marked[i][j] && startWith(path))
                    dfs(res, board, path, i, j);
            }
        }
        return new ArrayList<String>(res);
    }
    
    private void dfs(HashSet<String> res, char[][] board, String path, int i, int j) {
        if(search(path)) res.add(path);
        marked[i][j] = true;
        for(int[] near : neighbor(board.length, board[0].length, i, j)) {
            int x = near[0];
            int y = near[1];
            char c = board[x][y];
            if(!marked[x][y] && startWith(path + c)) 
                dfs(res, board, path + c, x, y);
        } 
        marked[i][j] = false;
    }
    
    private Iterable<int[]> neighbor(int row, int col, int i, int j) {
        ArrayList<int[]> res = new ArrayList<>();
        for(int k = 0; k < dirX.length; k++) {
            int x = i + dirX[k];
            int y = j + dirY[k];
            if(x >= 0 && x < row && y >= 0 && y < col) {
                res.add(new int[]{x, y});
            }
        }
        return res;
    }
    
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        root = insert(root, word, 1, 0);
    }
    
    private TrieNode insert(TrieNode x, String word, int val, int index) {
        if(x == null) x = new TrieNode();
        if(index == word.length()) {
            x.val = val;
            return x;
        }
        char c = word.charAt(index);
        x.next[c - 'a'] = insert(x.next[c - 'a'], word, val, index + 1);
        return x;
    }
    
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode x = search(root, word, 0);
        if(x == null || x.val != 1) return false;
        return true;
    }
    
    private TrieNode search(TrieNode x, String word, int index) {
        if(x == null) return null;
        if(index == word.length()) return x;
        char c = word.charAt(index);
        return search(x.next[c - 'a'], word, index + 1);
    }
    
    public boolean startWith(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode x = search(root, word, 0);
        if(x == null) return false;
        return true;
    }
    
    private class TrieNode {
        int val;
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
            val = 0;
        }
    }
}