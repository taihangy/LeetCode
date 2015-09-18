public class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0 || k < 1) return null;
        int[] nums = new int[n];
        int total = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n ; i++) {
            nums[i - 1] = i;
            sb.append(i);
            total *= i;
        }
        k = k % total == 0? total : k % total;
        int count = 1;
        String next = sb.toString();
        while(count < k) {
            next = nextPer(nums);
            count++;
        }
        return next;
    }
    private String nextPer(int[] nums) {
        StringBuilder res = new StringBuilder();
        int vio = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                vio = i;
                break;
            }
        }
        int swap = -1;
        for(int i = nums.length - 1; i > vio; i--)
            if(nums[i] > nums[vio]) {
                swap = i;
                break;
            }
        swap(nums, vio, swap);
        for(int i = vio + 1, j = nums.length - 1; i < j; i++, j--)
            swap(nums, i, j);
        for(int elem : nums) res.append(elem);
        return res.toString();
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public String getPermutation(int n, int k) {
        if(n < 1) return "";
        k--;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) num.add(i);
        StringBuilder res = new StringBuilder();
        int fac = 1;
        for(int i = 2; i <= n - 1; i++) fac *= i;
        int round = n - 1;
        while(round >= 0) {
            int index = k / fac;
            k %= fac;
            res.append(num.get(index));
            num.remove(index);
            if(round > 0)
                fac /= round;
            round--;
        }
        return res.toString();
    }
}