public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return false;
        int left = 0, right = num.length() - 1;
        while(left <= right) {
            if(!isStro(num.charAt(left++), num.charAt(right--))) return false;
        }
        return true;
    }
    
    private boolean isStro(char left, char right) {
        boolean isStro = false;
        switch(left) {
            case '0': if(right == '0') isStro = true; break;
            case '1': if(right == '1') isStro = true; break;
            case '8': if(right == '8') isStro = true; break;
            case '6': if(right == '9') isStro = true; break;
            case '9': if(right == '6') isStro = true; break;
        }
        return isStro;
    }
}