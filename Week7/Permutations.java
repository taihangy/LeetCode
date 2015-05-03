public class Permutations{
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return res;
        helper(nums,new boolean[nums.length],res,new ArrayList<Integer>());
        return res;
    }
    private void helper(int[] nums,boolean[] used, List<List<Integer>> res,List<Integer> per){
        if(per.size()==nums.length){
            res.add(new ArrayList<Integer>(per));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                per.add(nums[i]);
                helper(nums,used,res,per);
                per.remove(per.size()-1);
                used[i]=false;
            }
        }
    }
}