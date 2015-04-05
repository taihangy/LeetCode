public class SpiralMatrix{
	public List<Integer> spiralOrder(int[][] matrix) {
        //这里没说是方正，因此要判断行列哪一个小，才能判断层数
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        int m=matrix.length;
        int n=matrix[0].length;
        int min=Math.min(m,n);
        //每一层各有两行两列
        int levelNum=min/2;
        //在每一层右下左上的顺序循环赋值
        for(int level=0;level<levelNum;level++){
            for(int i=level;i<n-level-1;i++) res.add(matrix[level][i]);
            for(int i=level;i<m-level-1;i++) res.add(matrix[i][n-level-1]);
            for(int i=n-level-1;i>level;i--) res.add(matrix[m-level-1][i]);
            for(int i=m-level-1;i>level;i--) res.add(matrix[i][level]);
        }
        //若为单数，则最后一行或者一列需要加进去
        if(min%2==1){
            if(m<n){
                for(int i=levelNum;i<n-levelNum;i++)
                    res.add(matrix[levelNum][i]);
            }else{
                for(int i=levelNum;i<m-levelNum;i++)
                    res.add(matrix[i][levelNum]);
            }
        }
        return res;
    }
}