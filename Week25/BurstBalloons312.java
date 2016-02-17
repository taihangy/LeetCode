public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] balloons = new int[nums.length + 2];
        int index = 1;
        for (int num : nums) {
            if (num > 0) balloons[index++] = num;
        }
        balloons[0] = 1;
        balloons[index++] = 1;
        int[][] cache = new int[index][index];
        return maxCoins(balloons, cache, 0, index - 1);
    }
    
    private int maxCoins(int[] balloons, int[][] cache, int left, int right) {
        if (left + 1 == right) return 0;
        if (cache[left][right] != 0) return cache[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, balloons[left] * balloons[i] * balloons[right]
                  + maxCoins(balloons, cache, left, i) + maxCoins(balloons, cache, i, right));
        }
        cache[left][right] = res;
        return res;
    }
}