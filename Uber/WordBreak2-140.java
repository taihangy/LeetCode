public class Solution {
  // TLE - recursive
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return res;
        helper(res, s, wordDict, "", 0);
        return res;
    }
    
    private void helper(List<String> res, String s, Set<String> wordDict, String item, int index) {
        if (index == s.length()) {
            res.add(item.trim());
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
           String word = s.substring(index, i);
           if (wordDict.contains(word)) {
               helper(res, s, wordDict, item + word + " ", i);
           }
        }
    }
}

public class Solution {
  //DP
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return res;
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        List<String> list = new ArrayList<String>();
        list.add("");
        map.put(0, list);
        for (int i = 1; i <= s.length(); i++) {
            List<String> value = new ArrayList<String>();
            for (int j = i - 1; j >= 0; j--) {
                String str = s.substring(j, i);
                if (wordDict.contains(str)) {
                    for (String word : map.get(j)) {
                        value.add(word.length() == 0 ? str : word + " " + str);
                    }
                }
            }
            map.put(i, value);
        }
        return map.get(s.length());
    }
}

public class Solution {
  // HashMap + recursive
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return helper(s, wordDict, map);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<String>();
        for (int len = 1; len <= s.length(); len++) {
           String str = s.substring(0, len);
           if (wordDict.contains(str)) {
               if (len == s.length()) {
                    res.add(str);
               }
               else {
                   List<String> rest = helper(s.substring(len), wordDict, map);
                   for (String word : rest) {
                        res.add(str + " " + word);
                   }
               }
           }
        }
        map.put(s, res);
        return res;
    }
}