public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0) return 0;
        if(k>=prices.length) return buyMany(prices);
        int[] local=new int[k+1];
        int[] global=new int[k+1];
        for(int i=0;i<prices.length-1;i++){
            int diff=prices[i+1]-prices[i];
            for(int j=k;j>=1;j--){
                local[j]=Math.max(global[j-1]+(diff>0?diff:0),local[j]+diff);
                global[j]=Math.max(global[j],local[j]);
            }
        }
        return global[k];
    }
    
    private int buyMany(int[] prices){
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            int diff=prices[i+1]-prices[i];
            if(diff>0) max+=diff;
        }
        return max;
    }
}