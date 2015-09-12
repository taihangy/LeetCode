public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        s = s.trim().replaceAll("[\\p{Space}]+", " ");
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i] + " ");
        }
        return res.toString().trim();
    }
}