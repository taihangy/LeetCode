public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0) return -1;
        int[] minHealth={Integer.MAX_VALUE};
        dfs(dungeon,0,0,minHealth,dungeon[0][0]);
        return minHealth[0];
    }
    private void dfs(int[][] dungeon,int i,int j,int[] minHealth,int sum){
        if(sum<0&&Math.abs(sum)+1>minHealth[0]) return; 
        if(i==dungeon.length-1&&j==dungeon[0].length-1){
            int health=sum>0?1:-sum+1;
            minHealth[0]=health<minHealth[0]?health:minHealth[0];
        }
        if(i<dungeon.length&&j+1<dungeon[0].length) dfs(dungeon,i,j+1,minHealth,sum+dungeon[i][j+1]);
        if(i+1<dungeon.length&&j<dungeon[0].length) dfs(dungeon,i+1,j,minHealth,sum+dungeon[i+1][j]);
        
    }
}