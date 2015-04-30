public class WordBreak{
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null||s.length()==0||wordDict.isEmpty()) return false;
        boolean[] res=new boolean[s.length()+1];
        res[0]=true;
        for(int i=0;i<s.length();i++){
            StringBuilder str=new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j]&&wordDict.contains(str.toString())){
                    res[i+1]=true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
}