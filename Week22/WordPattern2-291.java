public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }
    
    private boolean isMatch(String str, int i, String pattern, int j, HashMap<Character, String> map, HashSet<String> set) {
        if(i == str.length() && j == pattern.length()) return true;
        else if(i == str.length() || j == pattern.length()) return false;
        
        char p = pattern.charAt(j);
        if(map.containsKey(p)) {
            String s = map.get(p);
            if(str.startsWith(s, i)) {
                return isMatch(str, i + s.length(), pattern, j + 1, map, set);
            }
            return false;
        }
        for(int k = i; k < str.length(); k++) {
            String s = str.substring(i, k + 1);
            if(set.contains(s)) continue;
            map.put(p, s);
            set.add(s);
            if(isMatch(str, k + 1, pattern, j + 1, map, set)) return true;
            map.remove(p);
            set.remove(s);
        }
        return false;
    }
}