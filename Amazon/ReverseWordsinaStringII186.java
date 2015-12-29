public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        char[] res = new char[s.length];
        int count = 0;
        int index = 0;
        for(int i = s.length - 1; i >= 0; i--) {
            if(s[i] == ' ') {
                for(int j = i + 1; count > 0; count--, j++) {
                    res[index++] = s[j]; 
                }
                res[index++] = ' ';
            } 
            else {
                count++;
            }
        }
        for(int j = 0; count > 0; count--, j++) {
            res[index++] = s[j];
        }
        for(int i = 0; i < s.length; i++) {
            s[i] = res[i];
        }
    }
}

public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        reverse(s, 0, s.length - 1);
        for(int begin = 0, end = 0; end <= s.length; end++) {
            if(end == s.length || s[end] == ' ') {
                reverse(s, begin, end - 1);
                begin = end + 1;
            }
        }
    }
    
    private void reverse(char[] s, int begin, int end) {
        while(begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }
}