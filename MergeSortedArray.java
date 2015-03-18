public class MergeSortedArray{
	public void merge(int A[],int m,int B[],int n){
		int[] aux=new int[m];
		for(int k=0;k<m;k++)
			aux[k]=A[k];
		int i=0,j=0;
		for(int k=0;k<m+n;k++){
			if(i>m-1) A[k]=B[j++];
			else if(j>n-1) A[k]=aux[i++];
			else if(aux[i]<=B[j]) A[k]=aux[i++];
			else			 A[k]=B[j++];
		}
	}
}