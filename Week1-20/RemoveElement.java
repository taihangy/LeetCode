public class RemoveElement{
	public int removeElement(int[] A,int elem){
		//保有一个指针，用于当A[i]!=elem时添加A[i]元素
		int index=0;
		for(int i=0;i<A.length;i++){
			if(A[i]!=elem){
				A[index++]=A[i];
			}
		}
		return index;
	}

	public static void main(String args[]){
		RemoveElement re=new RemoveElement();
		int[] A={1,2,3,4,5};
		int newLength=re.removeElement(A,2);
		System.out.println(newLength);
		for(int num:A)
			System.out.print(num+" ");
	}
}