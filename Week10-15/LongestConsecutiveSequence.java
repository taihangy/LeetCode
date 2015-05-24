public class Solution {
    //空间复杂度O(n),时间复杂度O(n),因为不会有两个链都接到一个上，每个元素最多访问一次
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int maxLen=1;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(!set.isEmpty()){
            Iterator iter=set.iterator();
            int item=(Integer)iter.next();
            set.remove(item);
            int len=1;
            int prev=item-1;
            while(set.contains(prev)){
                len++;
                set.remove(prev);
                prev--;
            }
            int next=item+1;
            while(set.contains(next)){
                len++;
                set.remove(next);
                next++;
            }
            maxLen=Math.max(len,maxLen);
        }
        return maxLen;
    }
}