public class Solution {
    // like dp, keep two field one is local max, which means the longest substring including this character, res means the global longest substring so far
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int last = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
                max++;
            } else if(map.containsKey(c) && map.get(c) + max >= i && map.get(c) >= last){
                last = map.get(c);
                max = i - last;
                map.put(c, i);
            } else {
                map.put(c, i);
                max++;
            }
            if(max > res) res = max;
        }
        return res;
    }

    // i will walk through the whole s, j will keep the substring's head position which include this char.
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+ 1);
            }
            map.put(s.charAr(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}