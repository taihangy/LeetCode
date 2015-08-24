public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int[0];
        }
        boolean flag = true;
        int[] res = new int[digits.length];
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9) flag = false;
        }
        if(flag) {
            res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        System.arraycopy(digits, 0, res, 0, digits.length);
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            res[i] = digit;
            if(carry != 1) break;
        }
        return res;
    }
}