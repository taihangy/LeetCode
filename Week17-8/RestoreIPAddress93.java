public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0 || s.length() > 12) return res;
        helper(res, s, "", 0, 1);
        return res;
    }
    
    private void helper(List<String> res, String s, String item, int index, int segment) {
        if(index >= s.length()) return;
        if(segment == 4) {
            String str = s.substring(index);
            if(isValidIP(str)) res.add(item + "." + str);
            return;
        }
        for(int i = 1; i < 4 && (i + index) <= s.length(); i++) {
            String seg = s.substring(index, index + i);
            if(isValidIP(seg)) {
                if(segment == 1) helper(res, s, item + seg, index + i, segment + 1);
                else helper(res, s, item + "." + seg, index + i, segment + 1);
            }
        }
    }
    private boolean isValidIP(String s) {
        if(s.length() < 1 || s.length() > 3) return false;
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        int num = Integer.parseInt(s);
        if(num > 255 || num < 0) return false;
        return true;
    }
}