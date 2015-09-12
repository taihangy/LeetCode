public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null) return false;
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        int maxLen = getMax(wordDict);
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= i && j <= maxLen; j++) {
                if(res[i - j]) {
                    String word = s.substring(i - j, i);
                    if(wordDict.contains(word)) {
                        res[i] = true;
                        break;
                    }
                }
            }
        }
        return res[res.length - 1];
    }
    
    private int getMax(Set<String> wordDict) {
        int res = 0;
        for(String word : wordDict) {
            if(word.length() > res) res = word.length();
        }
        return res;
    }
}