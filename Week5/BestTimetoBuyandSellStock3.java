public class BestTimetoBuyandSellStock{
	//可以买k次
	//假设local[i][j]是第i天，第j次交易当天必须卖出的最优解
	//global[i][j]是第i天，第j次交易的最优接
	//local[i][j]是全局最优global[i-1][j-1]与第i天，第j次是否赚钱，赚钱就i-1天买i天卖，否则就i天买和卖，差为0
	//以及local[i-1][j]也就是说i-1天的第j次交易，在i天必须卖出，看哪个比较大
	//global[i][j]的话就是之前的global[i-1][j]和local[i][j]的较大值
	public int maxProfit(int[] prices){
		if(prices==null||prices.length==0||prices.length==1) return 0;
		int[] local=new int[3];
		int[] global=new int[3];
		for(int i=0;i<prices.length-1;i++){
			int diff=prices[i+1]-prices[i];
			//注意次序，local第j次交易，是和global的i-1天得j-1次交易有关的，所以要先更新j，再更新j-1
			for(int j=2;j>=1;j--){
				//注意括号
				local[j]=Math.max(global[j-1]+(diff>0?diff:0),local[j]+diff);
				global[j]=Math.max(global[j],local[j]);
			}
		}
		return global[2];
	}
}