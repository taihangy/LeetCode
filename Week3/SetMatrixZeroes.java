public class SetMatrixZeroes{
    //此题可以从空间复杂度O(m*n)到O(m+n)到O(1)
    //下面这种就是O(1)，可以使用第一行和第一列来存储(0或1)某一行某一列上的元素需不需要置0
	public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        int m=matrix.length;
        int n=matrix[0].length;
        boolean colflag=false,rowflag=false;
        //第一行第一列先判断需不需要置0
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
        //从第二行第二列开始，如果元素为0，则对应第一行的该列与第一列的该行置0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //若第一行或第一列中对应的为0，则置0，否则保持
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        //第一行和第一列是否要全部置0
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
        //保持两个数组作为记录，因此空间复杂度为O(m+n)
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