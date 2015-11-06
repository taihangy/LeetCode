public class Solution {
    //TLE
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0 || wordDict.size() == 0) return res;
        helper(s, "", wordDict, res, 0);
        return res;
    }
    
    private void helper(String s, String path, Set<String> wordDict, List<String> res, int index) {
        if(index == s.length()) {
            res.add(path.trim());
            return;
        }
        for(int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if(wordDict.contains(sub)) {
                helper(s, path + sub + " ", wordDict, res, i);
            }
        }
    }
}

//Use Map to store history info
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0 || wordDict.size() == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, wordDict, map);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        for(int len = 1; len <= s.length(); len++) {
            String str = s.substring(0, len);
            if(wordDict.contains(str)) {
                if(s.length() == len) {
                    res.add(str);
                }
                else {
                    String sub = s.substring(len);
                    List<String> rest = helper(sub, wordDict, map);
                    for(String r : rest) {
                        res.add(str + " " + r);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

//DP version from start to end, keep every position with its possible string
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();
        List<String> list = new ArrayList<String>();
        list.add("");
        validMap.put(0, list);
        
        for(int i = 1; i <= s.length(); i++) {
            List<String> value = new ArrayList<String>();
            for(int j = i - 1; j >= 0; j--) {
                String str = s.substring(j, i);
                if(wordDict.contains(str)) {
                    for(String word : validMap.get(j)) {
                        value.add(word.isEmpty()? "" + str : word + " " + str);
                    }
                }
            }
            validMap.put(i, value);
        }
        
        return validMap.get(s.length());
    }
}