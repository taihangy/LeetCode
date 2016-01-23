public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) return false;
        int n = num.length();
        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            for (int j = i + 1; j - i <= n - j && i <= n - j; j++) {
                if (num.charAt(i) == '0' && j - i > 1) break;
                long pre = Long.parseLong(num.substring(0, i));
                long cur = Long.parseLong(num.substring(i, j));
                if (isAdditiveNumber(num.substring(j), pre, cur)) return true;
            }
        }
        return false;
    }
    
    private boolean isAdditiveNumber(String num, long pre, long cur) {
        if (num.equals("")) return true;
        
        String sum = String.valueOf(pre + cur);
        if (!num.startsWith(sum)) return false;
        return isAdditiveNumber(num.substring(sum.length()), cur, pre + cur);
    }
}