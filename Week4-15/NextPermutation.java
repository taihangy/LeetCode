public class NextPermutation{
	public void nextPermutation(int[] num){
		if(num==null||null.length==0) return;
        //找到从数组尾部往前第一个比前一个值小的index，这个序号是要交换的位置，而与其交换的是刚好比他大的元素
		int p=-1;
        for(int i=num.length-1;i>0;i--){
            if(num[i]<=num[i-1]) continue;
            else{
                p=i-1;
                break;
            }
        }
        //如果序号是最后一位，说明序列是递减的，也就是最大的排列，则返回递增排列
        if(p==-1){
            for(int i=0,j=num.length-1;i<j;i++,j--){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        //先找到刚好比num[p]大的数，交换后，将p之后递减的序列变成递增，得到下一个排序
        else{
            int i;
            for(i=num.length-1;i>p;i--)
                if(num[i]>num[p]) break;
            int temp=num[p];
            num[p]=num[i];
            num[i]=temp;
            for(int x=p+1,y=num.length-1;x<y;x++,y--){
                int t=num[x];
                num[x]=num[y];
                num[y]=t;
            }
        }
	}
}