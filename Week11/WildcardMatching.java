public class Solution {
    public boolean isMatch(String s, String p) {  
        if(s==null||p==null) return false;
        int num=0;
        for(char c:p.toCharArray()){
            if(c!='*') num++;
        }
        if(num>s.length()) return false;
        
        boolean[] res=new boolean[s.length()+1];
        res[0]=true;
        for(int j=0;j<p.length();j++){
            if(p.charAt(j)!='*'){
                for(int i=s.length()-1;i>=0;i--){
                    res[i+1]=res[i]&&(p.charAt(j)=='?'||(p.charAt(j)==s.charAt(i)));
                }
            }else{
                int index=0;
                while(index<=s.length()&&!res[index]) index++;
                while((++index)<=s.length()){
                    res[index]=true;
                }
            }
            res[0]=res[0]&&p.charAt(j)=='*';
        }
        return res[s.length()];
    }
}