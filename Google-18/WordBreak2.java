public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
        return helper(s, wordDict, wordMap);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> wordMap) {
        if (wordMap.containsKey(s)) return wordMap.get(s);
        List<String> res = new ArrayList<>();
        for (int end = 1; end <= s.length(); end++) {
            String sub = s.substring(0, end);
            if (wordDict.contains(sub)) {
                if (sub.length() == s.length()) {
                    res.add(sub);
                }
                else {
                    List<String> rest = helper(s.substring(end), wordDict, wordMap);
                    for (String word : rest) {
                        res.add(sub + " " + word);
                    }
                }
            }
        }
        wordMap.put(s, res);
        return res;
    }
}

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> validMap = new HashMap<>();
        List<String> l = new ArrayList<>();
        l.add("");
        validMap.put(0, l);
        for (int i = 1; i <= s.length(); i++) {
            List<String> tmp = new ArrayList<String>();
            for (int j = i - 1; j >= 0; j--) {
                String word = s.substring(j, i);
                if (wordDict.contains(word)) {
                    
                    for (String prevWord : validMap.get(j)) {
                       String sentence = prevWord.isEmpty() ? word : prevWord + word;
                       tmp.add(sentence);
                    }
                }   
            }
            validMap.put(i, tmp);
        }
        return validMap.get(s.length());
    }
}