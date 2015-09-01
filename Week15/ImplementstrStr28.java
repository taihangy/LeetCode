public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null) return -1;
        if(needle == null || needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        int lenOfNeedle = needle.length(), lenOfHay = haystack.length();
        for(int i = 0; i < lenOfHay - lenOfNeedle + 1; i++) {
            if(haystack.substring(i, i + lenOfNeedle).equals(needle)) return i;
        }
        return -1;
    }
}