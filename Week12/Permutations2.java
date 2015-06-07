public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set=new HashSet<List<Integer>>();
        helper(nums,new boolean[nums.length],set,new ArrayList<Integer>());
        List<List<Integer>> res=new ArrayList<List<Integer>>(set);
        return res;
    }
    private void helper(int[] nums,boolean[] used,HashSet<List<Integer>> set,ArrayList<Integer> per){
        if(per.size()==nums.length){
            set.add(new ArrayList<Integer>(per));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                per.add(nums[i]);
                helper(nums,used,set,per);
                used[i]=false;
                per.remove(per.size()-1);
            }
        }
    }
}