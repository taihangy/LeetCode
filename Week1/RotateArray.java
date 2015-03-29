public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray ra=new RotateArray();
		int[] nums={1,2};
		ra.rotate(nums, 1);
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
	}
	
	public void rotate(int[] nums, int k) {
        int N=nums.length;
        //copy作为辅助存储
        int[] copy=new int[N];
        for(int i=0;i<N;i++){
        	//i+k % N 即新的位置
            copy[(i+k)%N]=nums[i];
        }
        //注意这里的nums是传过来的数组,如果直接num=copy只是改变了指针的指向，并没有传回去
        for(int i=0;i<N;i++)
        	nums[i]=copy[i];
    }

}