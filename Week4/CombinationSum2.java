public class CombinationSum2{
    //和CombinationSum类似
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num==null||num.length==0) return res;
        Arrays.sort(num);
        return helper(num,target,res,new ArrayList<Integer>(),0);
    }
    public List<List<Integer>> helper(int[] num,int target,List<List<Integer>> res,ArrayList<Integer> item,int start){
        if(target<0) return res;
        else if(target==0){
            res.add(new ArrayList<Integer>(item));
            return res;
        }
        for(int i=start;i<num.length;i++){
            if(i>start&&num[i]==num[i-1]) continue;
            item.add(num[i]);
            //注意不能出现duplicate加要i+1
            helper(num,target-num[i],res,item,i+1);
            item.remove(item.size()-1);
            if(target==num[i]) break;
        }
        return res;
    }
}