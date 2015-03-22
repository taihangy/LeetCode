public class RemoveDulicatesFromSortedArray{
	public int removeDuplicates(int[] A){
		int len=A.length;
		if(len==0) return 0;
		if(len==1) return 1;
		//保持一个index指针，若A[i]==A[index]则i++，否则赋值。
		int index=0;		
		for(int i=1;i<len;i++){
			if(A[index]!=A[i])
				A[++index]=A[i];
		}
		return index+1;
	}
	public static void main(String args[]){
		RemoveDulicatesFromSortedArray rd=new RemoveDulicatesFromSortedArray();
		int[] A={1,2,2,2,2,3,3,4};
		int length=rd.removeDuplicates(A);
		System.out.println(length);
		for(int num:A)
			System.out.print(num+" ");
	}
}