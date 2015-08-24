public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(k<=0||n<1) return res;
        boolean[] marked=new boolean[9];
        helper(k,n,1,res,new ArrayList<Integer>(),marked);
        return res;
    }
    private void helper(int k,int n,int start,List<List<Integer>> res,ArrayList<Integer> list,boolean[] marked){
        if(k==0&&n==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(k==0&&n!=0) return;
        for(int i=start;i<=9;i++){
            if(!marked[i-1]){
                marked[i-1]=true;
                list.add(i);
                helper(k-1,n-i,i,res,list,marked);
                list.remove(list.size()-1);
                marked[i-1]=false;
            }
        }
    }
}