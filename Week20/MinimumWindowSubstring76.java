public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.containsKey(c)? map.get(c) + 1 : 1);
        }
        int start = 0, minlen = Integer.MAX_VALUE, count = 0, left = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count++;
                while(count == t.length()) {
                    if(i - left + 1 < minlen) {
                        minlen = i - left + 1;
                        start = left; 
                    }
                    char lc = s.charAt(left);
                    if(map.containsKey(lc)) {
                        map.put(lc, map.get(lc) + 1);
                        if(map.get(lc) > 0) count--;
                    }
                    left++;
                }
            }
        }
        return minlen == Integer.MAX_VALUE?"" : s.substring(start, start + minlen);
    }
}