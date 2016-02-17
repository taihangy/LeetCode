public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return isMatch(map, set, pattern, 0, str, 0);
    }
    
    private boolean isMatch(HashMap<Character, String> map, HashSet<String> set, String pattern, int i, String str, int j) {
        if (i == pattern.length() && j == str.length()) return true;
        else if (i == pattern.length() || j == str.length()) return false;
        
        char p = pattern.charAt(i);
        if (map.containsKey(p)) {
            String ps = map.get(p);
            if (str.startsWith(ps, j) && isMatch(map, set, pattern, i + 1, str, j + ps.length())) return true;
        }
        else {
            for (int k = j + 1; k <= str.length(); k++) {
                String sub = str.substring(j, k);
                if (set.add(sub)) {
                    map.put(p, sub);
                    if (isMatch(map, set, pattern, i + 1, str, k)) return true;
                    map.remove(p);
                    set.remove(sub);
                }
            }
        }
        return false;
    }
}