public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        StringBuilder res = new StringBuilder();
        int N = num1.length();
        int M = num2.length();
        int num = 0;
        for(int i = 1; i <= N + M; i++) {
            for(int j = 1; j <= Math.min(N, i); j++) {
                int k = i - j + 1;
                if(k <= M) num += (num1.charAt(N - j) - '0') * (num2.charAt(M - k) - '0');
            }
            if(num > 0 || i != N + M) res.append(num % 10);
            num /= 10;
        }
        return res.reverse().toString();
    }
}