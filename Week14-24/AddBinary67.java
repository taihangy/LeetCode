public class Solution {
    // be aware of a and b cannot be converted into int, because it could beyond the scope of Integer
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
            // just use insert, not append then reverse, it will make unexpected mistakes
            res.insert(0, digit);
        }
        if(a.length() < b.length()) {
            // be aware of index issue
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
        // carry is 1, then add it
        if(carry == '1') res.insert(0, carry);
        return res.toString();
    }

    // version 2
    // ^ means + in binary add, 1 ^ 1 = 0, 0 ^ 0 = 0, 1 ^ 0 = 1
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) return b;
        if(b == null || b.isEmpty()) return a;
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aByte, bByte;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry == 1) {
            aByte = i >= 0? Character.getNumericValue(aCharArray[i--]) : 0;
            bByte = j >= 0? Character.getNumericValue(bCharArray[j--]) : 0;
            int result = aByte ^ bByte ^ carry;
            carry = (aByte + bByte + carry) >= 2? 1 : 0;
            res.append(result);
        }
        return res.reverse().toString();
    }
















}