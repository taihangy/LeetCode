public class Solution {
    //超时
    public int minCut(String s) {
        if(s==null||s.length()==0) return 0;
        boolean[][] dict=getDict(s);
        int[] min={s.length()};
        helper(s,dict,0,min,new int[1]);
        return min[0]-1;
    }
    
    private void helper(String s,boolean[][] dict,int start,int[] min,int[] count){
        if(start>=s.length()){
            if(count[0]<min[0]) min[0]=count[0];
            return;
        }
        for(int i=start;i<s.length();i++){
            if(dict[start][i]){
                count[0]++;
                helper(s,dict,i+1,min,count);
                count[0]--;
            }
        }
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