public class FactorialTrailingZeroes{
	public int trailingZreos(int n){
		int count=0;
		//带有是2、5倍数的元素想乘能产生0，而2的倍数远远大于5的倍数，因此只需要考虑5倍数的元素个数
		//先找出5的倍数，加上25的倍数（2个5，之前一个已经加过），再找出125（3个5，之前2个已经加过）
		for(int i=n/5;i>0;i/=5) count=count+i;
		return count;
	}
}