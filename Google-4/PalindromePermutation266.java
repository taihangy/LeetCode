public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        boolean isOdd = s.length() % 2 == 1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c)? map.get(c) + 1 : 1);
        }
        if(!isOdd) {
            for(Integer count : map.values()) {
                if(count % 2 != 0) return false;
            }
            return true;
        } else {
            int one = 0;
            for(Integer count : map.values()) {
                if(count % 2 == 0) continue;
                else {
                    one++;
                    if(one > 1) return false;
                }
            }
            return true;
        }
    }
}