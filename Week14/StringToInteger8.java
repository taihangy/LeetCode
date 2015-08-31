public class Solution {
    // just corner case
    // discard white space
    // overflow
    // sign of the number 
    // invalid input
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        boolean isNeg = false;
        int index = 0;
        int count = 0;
        while(index < str.length()) {
            if(count > 1) return 0;
            char c = str.charAt(index);
            if(c != '-' && c != '+') break;
            else if(c == '-') isNeg = !isNeg;
            index++;
            count++;
        }
        int sum = 0;
        while(index < str.length()) {
            char c = str.charAt(index);
            int num = c - '0';
            if(num < 0 || num > 9){
            	break;
            }
            // be aware of this overflow case
            if(!isNeg && sum > (double)((Integer.MAX_VALUE - num) / 10)) return Integer.MAX_VALUE;
            if(isNeg && - sum  < (double)((Integer.MIN_VALUE + num) / 10)) return Integer.MIN_VALUE;
            sum = sum * 10 + num;
            index++;
        }
        return isNeg?-sum : sum;
    }
}