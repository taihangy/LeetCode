public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9)
            return false;
        int n=board.length;
        
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