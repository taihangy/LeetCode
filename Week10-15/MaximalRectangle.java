public class Solution {
    //按照柱状图最大矩形的思路做，每次遍历矩阵的一行，算最大矩阵，当某一行元素为0时，则height为0
    //时间复杂度O(m*n),空间复杂度O(n)
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int maxRect=0;
        int[] height=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                height[j]=matrix[i][j]=='0'?0:height[j]+1;
            }
            maxRect=Math.max(maxRect,largestRect(height));
        }
        return maxRect;
    }
    private int largestRect(int[] height){
        //和LargestRectangleinHistogram一样，维护一个数组，当遇到小于栈顶的时候出栈，计算每个出栈的可能的最大矩阵
        if(height==null||height.length==0) return 0;
        LinkedList<Integer> stack=new LinkedList<Integer>();
        int max=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int index=stack.pop();
                int area=stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
                max=Math.max(max,area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index=stack.pop();
            int area=stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
            max=Math.max(max,area);
        }
        return max;
    }
}