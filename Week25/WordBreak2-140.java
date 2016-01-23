public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add(s);
        }
        else {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (wordDict.contains(s.substring(j))) break;
                else if (j == 0) return res;
            }
            for (int i = 1; i <= s.length(); i++) {
                if (wordDict.contains(s.substring(0, i))) {
                    List<String> rest = wordBreak(s.substring(i), wordDict);
                    if (!rest.isEmpty()) {
                        for (String one : rest) {
                            String all = s.substring(0, i) + " " + one;
                            res.add(all.trim());
                        }
                    }
                }
            }
        }
        return res;
    }
}