public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int maxSquare=0;
        int[] height=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                height[j]=matrix[i][j]=='0'?0:height[j]+1;
            }
            maxSquare=Math.max(maxSquare,largerestSquare(height));
        }
        return maxSquare;
    }
    private int largerestSquare(int[] height){
        LinkedList<Integer> stack=new LinkedList<Integer>();
        int max=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int index=stack.pop();
                int base=stack.isEmpty()?i:(i-stack.peek()-1);
                int area=(int)Math.pow(Math.min(height[index],base),2);
                max=Math.max(max,area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index=stack.pop();
            int base=stack.isEmpty()?height.length:(height.length-stack.peek()-1);
            int area=(int)Math.pow(Math.min(height[index],base),2);
            max=Math.max(max,area);
        }
        return max;
    }

    //DP
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int max=0;
        for(int i=0;i<matrix.length;i++)
            if(matrix[i][0]=='1') {
                max=1;
                break;
            }
        if(max==0){
            for(int i=0;i<matrix[0].length;i++)
                if(matrix[0][i]=='1') {
                    max=1;
                    break;
                }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    matrix[i][j]=(char)((Math.min(Math.min(matrix[i][j-1]-'0',matrix[i-1][j]-'0'),matrix[i-1][j-1]-'0')+1)+'0');
                    max=Math.max(max,matrix[i][j]-'0');
                }
            }
        }
        return max*max;
    }
}