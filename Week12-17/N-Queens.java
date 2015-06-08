public class Solution {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res=new ArrayList<String[]>();
        helper(n,0,new int[n],res);
        return res;
    }
    private void helper(int n,int row,int[] colForRow,ArrayList<String[]> res){
        if(row==n){
            String[] board=new String[n];
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(j==colForRow[i]) sb.append('Q');
                    else sb.append('.');
                }
                board[i]=sb.toString();
            }
            res.add(board);
            return;
        }
        for(int i=0;i<n;i++){
            colForRow[row]=i;
            if(check(row,colForRow)){
                helper(n,row+1,colForRow,res);
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