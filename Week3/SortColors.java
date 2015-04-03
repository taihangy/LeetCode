public class SortColors{
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
}