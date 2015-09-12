public class Solution {
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
}