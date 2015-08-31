public class Solution {
    public boolean isUgly(int num) {
        // there is no other facter, except 2, 3, 5
        //
        if(num <= 0) return false;
        if(num == 1) return true;
        while(num % 5 == 0) {
            num /= 5;
        }
        while(num % 3 == 0) {
            num /= 3;
        }
        while(num % 2 == 0) {
            num /= 2;
        }
        if(num != 1) return false;
        return true;
    }
}