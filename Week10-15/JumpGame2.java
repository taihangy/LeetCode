public class Solution {
    //空间复杂度O(1),时间复杂度O(n)，每次保存最远能到哪儿，如果i已经超出之前最远能到的距离，则更新
    public int jump(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int step=0;
        int reach=0;
        int lastReach=0;
        for(int i=0;i<=reach&&i<nums.length;i++){
            if(i>lastReach){
                step++;
                lastReach=reach;
            }
            reach=Math.max(reach,nums[i]+i);
        }
        return reach<nums.length-1?0:step;
    }
}