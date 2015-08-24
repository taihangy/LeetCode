public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null||nums.length<=1) return false;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
                if(i>=k) set.remove(nums[i-k]);
            }
        }
        return false;
    }
}