public class Solution {
	// time O(n * n), space O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--) {
        		// skip the duplicates
            if(i < nums.length - 1 && nums[i + 1] == nums[i]) continue;
            List<List<Integer>> curRes = twoSum(nums, i - 1, -nums[i]);
            for(int j = 0; j < curRes.size(); j++)
                curRes.get(j).add(nums[i]);
            res.addAll(curRes);
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int end, int target) {
        List<List<Integer>> curRes = new ArrayList<List<Integer>>();
        int i = 0;
        int j = end;
        while(i < j) {
            int a = nums[i], b = nums[j];
            if(a + b == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(a); list.add(b);
                curRes.add(list);
                i++;
                j--;
                //skip the duplicates1
                while(i < j && nums[i] == nums[i - 1]) i++;
                while(i < j && nums[j] == nums[j + 1]) j--;
            } 
            else if (a + b > target) j--;
            else i++;
        }
        return curRes;
    }
}

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        List<Integer> list;
        for(int i = 0; i < nums.length - 1; i++) {
            int target = -nums[i];
            int front = i + 1, end = nums.length - 1;
            while(front < end) {
                int sum = nums[front] + nums[end];
                if(sum < target) front++;
                else if(sum > target) end--;
                else {
                    list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[front]);
                    list.add(nums[end]);
                    res.add(new ArrayList<Integer>(list));
                    // becareful not nums[front + 1] == nums[front]
                    while(front < end && nums[front] == list.get(1)) front++;
                    while(front < end && nums[end] == list.get(2)) end--;
                }
            }
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}