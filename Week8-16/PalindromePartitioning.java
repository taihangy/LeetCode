public class PalindromePartitioning{
	public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<List<String>>();
        if(s==null||s.length()==0) return res;
        boolean[][] dict=getDict(s);
        helper(s,dict,res,new ArrayList<String>(),0);
        return res;
    }
    private void helper(String s,boolean[][] dict,List<List<String>> res,List<String> list,int start){
        if(start>=s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(dict[start][i]){
                list.add(s.substring(start,i+1));
                helper(s,dict,res,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean[][] getDict(String s){
        if(s==null||s.length()==0) return null;
        boolean[][] res=new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||res[i+1][j-1])){
                    res[i][j]=true;
                }
            }
        }
        return res;
    }

    public int minCut(String s) {
        if(s==null||s.length()==0) return 0;
        boolean[][] dict=getDict(s);
        int[] res=new int[s.length()+1];
        res[0]=0;
        for(int i=0;i<s.length();i++){
            res[i+1]=i+1;
            for(int j=0;j<=i;j++){
                if(dict[j][i]){
                    res[i+1]=Math.min(res[i+1],res[j]+1);
                }
            }
        }
        return res[s.length()]-1;
    }
    private boolean[][] getDict(String s){
        boolean[][] res=new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||res[i+1][j-1]))
                    res[i][j]=true;
            }
        }
        return res;
    }
}