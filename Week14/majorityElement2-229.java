public class Solution {
    // moore voting algorithm, at most 2 majority, and they could be the same one(as majority Element 1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate1) {
                count1++;
            } else if(nums[i] == candidate2) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            }else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        // check if the two candidate is the same and qualified
        int times1 = 0, times2 = 0;
        for(int i = 0; i <nums.length; i++) {
            if(nums[i] == candidate1) times1++;
            if(nums[i] == candidate2) times2++;
        }
        if(times1 > nums.length / 3)
            res.add(candidate1);
        if(times2 > nums.length / 3 && candidate1 != candidate2)
            res.add(candidate2);
        return res;
    }
}