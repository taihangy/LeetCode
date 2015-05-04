public class Combinations{
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(n<1||k>n) return res;
        boolean[] used=new boolean[n];
        helper(n,k,0,used,res,new ArrayList<Integer>());
        return res;
    }
    private void helper(int n,int k,int start,boolean[] used,List<List<Integer>> res,List<Integer> item){
        if(start>=k&&item.size()==k){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<n;i++){
            if(!used[i]){
                used[i]=true;
                item.add(i+1);
                helper(n,k,i+1,used,res,item);
                item.remove(item.size()-1);
                used[i]=false;
            }
        }
    }
}