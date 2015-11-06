public class Solution {
    //HashSet find the consecutive subsequence by iterator and remove the element when its length increasing
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int elem : nums) set.add(elem);
        int max = 0;
        while(!set.isEmpty()) {
            Iterator iter = set.iterator();
            int item = (Integer)iter.next();
            set.remove(item);
            int len = 1;
            int prev = item - 1;
            while(set.contains(prev)) {
                len++;
                set.remove(prev);
                prev--;
            }
            int next = item + 1;
            while(set.contains(next)) {
                len++;
                set.remove(next);
                next++;
            }
            max = max < len? len : max;
        }
        return max;
    }

    //HashMap version which could save sequence boundary and corresponding length of that subsequence
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            if(!map.containsKey(elem)) {
                int left = map.containsKey(elem - 1)? map.get(elem - 1) : 0;
                int right = map.containsKey(elem + 1)? map.get(elem + 1) : 0;
                int sum = left + right + 1;
                map.put(elem, sum);
                map.put(elem - left, sum);
                map.put(elem + right, sum);
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}