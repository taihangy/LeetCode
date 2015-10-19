public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String res = "1";
        for(int i = 1; i < n; i++) {
            res = next(res);
        }
        return res;
    }
    
    private String next(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) count++;
            else {
                res.append(count).append(s.charAt(i));
                count = 1;
            }
        }
        res.append(count).append(s.charAt(s.length() - 1));
        return res.toString();
    }
}