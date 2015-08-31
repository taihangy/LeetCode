public class rotateArray189 {
    //version 1
    // time O(n), space O(n)
    public void rotate1(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int[] rotate = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            rotate[(i+k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i]=rotate[i];
        }
    }

    // version 2 just call System.arraycopy
    public void rotate2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        k = k % nums.length;
        int[] rotate = new int[nums.length];
        System.arraycopy(nums, nums.length - k, rotate, 0, k);
        System.arraycopy(nums, 0, rotate, k, nums.length - k);
        System.arraycopy(rotate, 0, nums, 0, nums.length);
    }

    // version 3, time O(n), space O(k % nums.length)
    public void rotate3(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int step = k % nums.length;
        int[] store = new int[step];
        for(int i = 0; i < step; i++)
            store[i] = nums[nums.length - step + i];
        // from back to head
        for(int i = nums.length - step - 1; i >= 0; i--) 
            nums[i + step] = nums[i];
        for(int i = 0; i < step; i++)
            nums[i] = store[i];
    }

    // version 4, revese & bit manipulation 
    // XOR: 0...0 ^ x = x, 1...1 ^ x = ~x, x ^ x = 0
    // XOR: exchange i and j, i ^= j, j ^= i, i ^= j
    public void rotate4(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int step = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, step - 1);
        reverse(nums, step, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            i++;
            j--;
        }
    }

    // version 5, GCD, advanced, not clear
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;

        //gcd path to finish movie
        for(int i = 0; i < gcd; i++){
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }

    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }


    public static void main(String[] args) {
        rotateArray189 s = new rotateArray189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        s.rotate4(nums, 3);
        System.out.prinln("a");
        for(int i : nums)
            System.out.println(i);
    }
}