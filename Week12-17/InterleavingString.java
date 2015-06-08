public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) 
            return false;
        String minWord=s1.length()>s2.length()?s2:s1;
        String maxWord=s1.length()>s2.length()?s1:s2;
        boolean[] res=new boolean[minWord.length()+1];
        res[0]=true;
        for(int i=0;i<minWord.length();i++){
            res[i+1]=res[i]&&minWord.charAt(i)==s3.charAt(i);
        }
        for(int i=0;i<maxWord.length();i++){
            res[0]=res[0]&&maxWord.charAt(i)==s3.charAt(i);
            for(int j=0;j<minWord.length();j++){
                res[j+1]=res[j+1]&&maxWord.charAt(i)==s3.charAt(i+j+1)||
                        res[j]&&minWord.charAt(j)==s3.charAt(i+j+1);
            }
        }
        return res[minWord.length()];
    }
}