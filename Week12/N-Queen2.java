public class Solution {
    private int num=0;
    public int totalNQueens(int n) {
        helper(n,0,new int[n]);
        return num;
    }
    
    private void helper(int n,int row,int[] colForRow){
        if(row==n){
            num++;
            return;
        }
        for(int i=0;i<n;i++){
            colForRow[row]=i;
            if(check(row,colForRow)){
                helper(n,row+1,colForRow);
            }
        }
    }
    private boolean check(int row,int[] colForRow){
        for(int i=0;i<row;i++){
            if(colForRow[i]==colForRow[row]||Math.abs(row-i)==Math.abs(colForRow[row]-colForRow[i]))
                return false;
        }
        return true;
    }
}