public class Solution {
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<=1) return s;
        String res=null;
        int mid=(s.length()-1)/2;
        for(int i=mid;i>=0;i--){
            int left,right;
            if(s.charAt(i)==s.charAt(i+1)){
                left=i;
                right=i+1;
            }else{
                left=i-1;
                right=i+1;
            }
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(left==-1){
                StringBuilder sb=new StringBuilder(s.substring(right));
                res=sb.reverse().toString()+s;
                break;
            }
        }
        return res;
    }
}