public class MergeSortedArray{
	public void merge(int A[],int m,int B[],int n){
		//inplace merge很难实现，因此添加aux[]
		int[] aux=new int[m];
		//将aux赋值
		for(int k=0;k<m;k++)
			aux[k]=A[k];
		int i=0,j=0;
		//当i或j超出时，直接赋值；当没有超出时，给A赋值较小的值
		for(int k=0;k<m+n;k++){
			if(i>m-1) A[k]=B[j++];
			else if(j>n-1) A[k]=aux[i++];
			else if(aux[i]<=B[j]) A[k]=aux[i++];
			else			 A[k]=B[j++];
		}
	}
}