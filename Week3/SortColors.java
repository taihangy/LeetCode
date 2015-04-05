public class SortColors{
	//http://blog.csdn.net/linhuanmars/article/details/24286349
	//里面有一种看不懂。。

	//这个是沿用了quick sort with duplicate key的思路，小于1放左边，等于1放中间，大于1放右边
	public void sortColors(int[] A){
		if(A==null||A.length==0) return;
		sort(A,0,A.length-1);
	}
	public static void sort(int[] A,int lo,int hi){
		int lt=lo,gt=hi;
		int i=lo;
		int v=1;
		while(i<=gt){
			if(A[i]<v) exch(A,lt++,i++);
			else if(A[i]>v) exch(A,gt--,i);
			else i++;
		}
	}
	public static void exch(int[] A,int i,int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}

	//k-index sort 计数排序
	public void sortColors(int[] A){
		if(A==null||A.length==0) return;
		int N=A.length;
		int[] aux=new int[N];
		int[] count=new int[4];
		for (int i=0;i<N;i++) {
			count[A[i]+1]++;
		}
		for(int i=0;i<3;i++){
			count[i+1]+=count[i];
		}
		for(int i=0;i<N;i++){
			aux[count[A[i]]++]=A[i];
		}
		for(int i=0;i<N;i++){
			A[i]=aux[i];
		}
	}

}