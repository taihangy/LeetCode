public class Solution {
    /**
    * Using Largest Hisgram
    */
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int max = 0;
        int[] height = new int[col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                height[j] = matrix[i][j] == '0'? 0 : height[j] + 1;
            }
            max = Math.max(max, Rect(height));  
        }
        return max;
    }
    
    private int Rect(int[] height) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int index = stack.pop();
                int area = stack.isEmpty()? i * height[index] : (i - stack.peek() - 1) * height[index];
                max = max < area? area : max;
            }    
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int area = stack.isEmpty()? height.length * height[index] : (height.length - stack.peek() - 1) * height[index];
            max = max < area? area : max;
        }
        return max;
    }

    /** DP solution
    * the maximum rectangle include matrix[i][j] is (right(i, j) - left(i, j)) * height(i, j)
    * the transition equation are:
    * left(i, j) = max(left(i - 1, j), curleft), which curleft is the nearest 0's position + 1 from the left part of i
    * right(i, j) = min(right(i - 1, j), curright), which curright is the nearest 0's position from the right part of i
    * height(i, j) = height(i - 1, j) + 1 if matrix[i][j] is not '0'
    * According to equations above we can calculate the area of a rectangle 
    * by multiply height(i, j) with right(i, j) minus left(i, j)
    */
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++) right[i] = n;
        for(int i = 0; i < m; i++) {
            int curleft = 0, curright = n;
            for(int j = 0; j < n; j++) height[j] = matrix[i][j] == '1'? height[j] + 1 : 0;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') left[j] = Math.max(left[j], curleft);
                else {
                    curleft = j + 1;
                    left[j] = 0;
                }
            }
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], curright);
                else {
                    curright = j;
                    right[j] = n;
                }
            }
            for(int j = 0; j < n; j++)
                max = Math.max(max, (right[j] - left[j]) * height[j]);
        }
        return max;
    }
}