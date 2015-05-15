public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null) return 0;
        int all=0;
        int sum=0;
        int pre=0;
        int minLen=nums.length;
        for(int i=0;i<nums.length;i++){
            all+=nums[i];
            sum+=nums[i];
            if(sum<s){
                continue;
            }else{
                while(sum>=s){
                    minLen=minLen>i-pre+1?i-pre+1:minLen;
                    sum-=nums[pre++];
                }
            }
        }
        return all<s?0:minLen;
    }
}