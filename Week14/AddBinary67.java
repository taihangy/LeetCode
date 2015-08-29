public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        // let a's length no longer than b's length
        if(a.length() > b.length()) {
            String c = a;
            a = b;
            b = c;
        }
        StringBuilder res = new StringBuilder();
        char carry = '0';
        char digit = '0';
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0; i--, j--) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(j);
            if((aChar == '1' && bChar == '1') && carry == '1') {
                digit = '1';
                carry = '1';
            }else if((aChar == '1' && bChar == '1') && carry == '0') {
                digit = '0';
                carry = '1';
            } else if((aChar == '1' || bChar == '1') && carry == '1') {
                digit = '0';
                carry = '1';
            } else if((aChar == '1' || bChar == '1') && carry == '0') {
                digit = '1';
                carry = '0';
            } else if((aChar == '0' && bChar == '0') && carry == '1') {
                digit = '1';
                carry = '0';
            } else {
                digit = '0';
                carry = '0';
            }
            res.insert(0, digit);
        }
        if(a.length() < b.length()) {
            for(int i = b.length() - a.length() - 1; i >= 0; i--) {
                char bChar = b.charAt(i);
                if(carry != '1') {
                    res.insert(0, b.substring(0, i + 1));
                    break;
                } else if(carry == '1' && bChar == '1') {
                    digit = '0';
                    carry = '1';
                } else {
                    digit = '1';
                    carry = '0';
                }
                res.insert(0, digit);
            }
        }
        if(carry == '1') res.insert(0, carry);
        return res.toString();
    }
}