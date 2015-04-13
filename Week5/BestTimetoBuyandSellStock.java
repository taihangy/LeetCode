public class BestTimetoBuyandSellStock{
	public int maxProfit(int[] prices){
		if(prices==null||prices.length==0||prices.length==1) return 0;
		int local=0;
		int global=0;
		for(int i=0;i<prices.length-1;i++){
			int diff=prices[i+1]-prices[i];
			local=Math.max(local+diff,0);
			global=Math.max(global,local);
		}
		return global;
	}
}