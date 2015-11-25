public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int lo = 0, hi = 0;
        int maxLen = 0;
        while(hi < s.length()) {
            if(map.size() <= 2) {
                char c = s.charAt(hi);
                map.put(c, hi);
                hi++;
            }
            if(map.size() > 2) {
                int leftmost = s.length();
                for(int index : map.values())
                    leftmost = Math.min(index, leftmost);
                char c = s.charAt(leftmost);
                map.remove(c);
                lo = leftmost + 1;
            }
            maxLen = Math.max(maxLen, hi - lo);
        }
        return maxLen;
    }
}