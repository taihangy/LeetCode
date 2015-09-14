public class Solution {
    // store last line each sum, time O(n), space O(1)
    // Top down
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] last = new int[triangle.get(0).size()];
        last[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            int lenCur = triangle.get(i).size();
            int[] current = new int[lenCur];
            for(int j = 0; j < lenCur; j++) {
                int element = triangle.get(i).get(j);
                if(j == 0) current[j] = last[j] + element;
                else if(j == lenCur - 1) current[j] = last[j - 1] + element;
                else current[j] = last[j - 1] > last[j] ? last[j] + element : last[j - 1] + element;
            }
            last = current;
        }
        int min = Integer.MAX_VALUE;
        for(int i : last) {
            min = min > i? i : min;
        }
        return min;
    }

    // Bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int sum = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }
}