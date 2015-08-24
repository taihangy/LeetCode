public class RotateImage{
    //使用extra space是可以实现的，但多用了空间O(n*n)
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;
        int n=matrix.length;
        int[][] copy=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                copy[i][j]=matrix[i][j];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[j][n-1-i]=copy[i][j];
    }

    //不用多余的空间，则要在每层上进行变化，用一个temp暂时存，然后4条边逐一交换，空间复杂度O(1)，时间复杂度O(N*N)
    public void rotate(int[][] matrix){
        if(matrix==null||matrix.length==0) return;
        int n=matrix.length;;
        int levelNum=n/2;
        for(int level=0;level<levelNum;level++){
            for(int i=level;i<n-1-level;i++){
                int temp=matrix[level][i];
                matrix[level][i]=matrix[n-1-i][level];
                matrix[n-1-i][level]=matrix[n-1-level][n-1-i];
                matrix[n-1-level][n-1-i]=matrix[i][n-1-level];
                matrix[i][n-1-level]=temp;
            }
        }
    }
}

