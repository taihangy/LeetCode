public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //判断行、列、九宫格是否满足条件
        if(board==null||board.length!=9||board[0].length!=9)
            return false;
        int n=board.length;
        
        //brute force的方法，检查行是否满足要求，用boolean map[]的方式
        for(int i=0;i<n;i++){
            boolean[] map=new boolean[9];
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    if(map[(int)(board[i][j]-'1')])
                        return false;
                    map[(int)(board[i][j]-'1')]=true;
                }
            }
        }
        
        //brute force的方法，检查列是否满足要求，用boolean map[]的方式
        for(int i=0;i<n;i++){
            boolean[] map=new boolean[9];
            for(int j=0;j<n;j++){
                if(board[j][i]!='.'){
                    if(map[(int)(board[j][i]-'1')])
                        return false;
                    map[(int)(board[j][i]-'1')]=true;
                }
            }
        }
        
        //brute force的方法，检查九宫格是否满足要求，用boolean map[]的方式
        for(int p=0;p<n;p+=3){
            for(int q=0;q<n;q+=3){
                boolean[] map=new boolean[9];
                 for(int i=p;i<p+3;i++){
                    for(int j=q;j<q+3;j++){
                        if(board[i][j]!='.'){
                            if(map[(int)(board[i][j]-'1')])
                                return false;
                            map[(int)(board[i][j]-'1')]=true;
                        }
                    }
                }
        
            }   
        }
        return true;
    }
}