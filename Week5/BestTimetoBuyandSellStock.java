public class BestTimetoBuyandSellStock{
	//可以交易1次，保有local和global，local是当天交易的最佳收获（如果是负数，则前一天卖掉，当天收获可以为0）
	//global是全局的最佳收获
	//递推equation： local[i+1]=max(prices[i+1]-prices[i]+local[i],0),这里是因为数据是已知的,所以可以知道第i天到底亏还是赚
	//global[i+1]递推就是global[i]和local[i+1]哪一个更高
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