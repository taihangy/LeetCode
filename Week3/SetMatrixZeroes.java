public class SetMatrixZeroes{
	public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        int m=matrix.length;
        int n=matrix[0].length;
        boolean colflag=false,rowflag=false;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                colflag=true;
                break;
            } 
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0) {
                rowflag=true;
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(colflag){
            for(int i=0;i<m;i++) matrix[i][0]=0;
        }
        if(rowflag){
            for(int j=0;j<n;j++) matrix[0][j]=0;
        }
    }

    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] rowflag=new boolean[m];
        boolean[] colflag=new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowflag[i]=true;
                    colflag[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowflag[i]||colflag[j])
                    matrix[i][j]=0;
            }
        }
    }
}