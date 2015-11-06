public class Solution {
    // same method, two pointer and be careful of the array tail
    // time O(n), space O(1)
    public List<String> summaryRanges(int[] nums) {
        if(nums == null) return null;
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        int last = nums[0];
        int lastIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(last + 1 != nums[i]) {
                StringBuilder range = new StringBuilder();
                range.append(nums[lastIndex]);
                if(i - 1 != lastIndex)
                    range.append("->").append(last);
                res.add(range.toString());
                last = nums[i];
            }
        }
        StringBuilder range = new StringBuilder();
        range.append(nums[lastIndex]);
        if(nums.length - 1 != lastIndex)
            range.append("->").append(last);
        res.add(range.toString());
        return res;
    }
}