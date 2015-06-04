public class Solution {
    private int res;
    public int numDistinct(String s, String t) {
        if(s==null||t==null||s.length()==0||t.length()==0||s.length()<=t.length()) return 0;
        helper(s,t,0,0);
        return res;
    }
    private void helper(String s,String t,int lastS,int lastT){
        if(lastT==t.length()-1) {
            res++;
            return;
        }
        for(int i=lastS;i<s.length();i++){
            if(s.charAt(i)==t.charAt(lastT)){
                helper(s,t,i+1,lastT+1);
            }
        }
    }
}