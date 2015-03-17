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
        int[] copy=new int[N];
        for(int i=0;i<N;i++){
            copy[(i+k)%N]=nums[i];
        }
        for(int i=0;i<N;i++)
        	nums[i]=copy[i];
    }

}