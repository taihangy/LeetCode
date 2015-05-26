public class Solution {
    public boolean isNumber(String s) {
        if(s==null) return false;
        s=s.trim();
        if(s.length()==0) return false;
        int i=0,end=s.length()-1;
        if(s.charAt(i)=='+'||s.charAt(i)=='-') i=1;
        boolean num=false;
        boolean dot=false;
        boolean exp=false;
        while(i<=end){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=true;
            }
            else if(c=='.'){
                if(exp||dot) return false;
                dot=true;
            }
            else if(c=='e'){
                if(exp||!num) return false;
                exp=true;
                num=false;
            }
            else if(c=='+'||c=='-'){
                if(s.charAt(i-1)!='e')
                    return false;
            }else{
                return false;
            }
            i++;
        }
        return num;
    }
}