public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) return null;
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            int digit = n % 26;
            if(digit == 0) digit = 26;
            char c = (char)('A' + digit - 1);
            res.append(c);
            n = (n - 1) / 26;
        }
        return res.reverse().toString();
    }
}