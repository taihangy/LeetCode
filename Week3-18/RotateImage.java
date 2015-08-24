public class RotateImage{
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

