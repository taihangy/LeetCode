public class Solution {
    //每一个都去尝试，是否可行，空间复杂度为栈的大小
    public void solveSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9) return;
        helper(board,0,0);
    }
    private boolean helper(char[][] board,int i,int j){
        if(j>=9)  
        return helper(board,i+1,0);  
        if(i==9)  
        {  
            return true;  
        }  
        if(board[i][j]=='.')  
        {  
            for(int k=1;k<=9;k++)  
            {  
                board[i][j] = (char)(k+'0');  
                if(isValid(board,i,j))  
                {  
                    if(helper(board,i,j+1))  
                        return true;  
                }  
                board[i][j] = '.';  
            }  
        }  
        else  
        {  
            return helper(board,i,j+1);  
        }  
        return false;  
    }
    private boolean isValid(char[][] board,int i,int j){
        for(int k=0;k<board.length;k++){
            if(k!=j&&board[i][k]==board[i][j]) return false;
        }
        for(int k=0;k<board[0].length;k++){
            if(k!=i&&board[k][j]==board[i][j]) return false;
        }
        for(int m=i/3*3;m<i/3*3+3;m++){
            for(int n=j/3*3;n<j/3*3+3;n++){
                if((m!=i||n!=j)&&board[m][n]==board[i][j]) return false;
            }
        }
        return true;
    }
}