public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        int N = nums.length, mid = N % 2 == 0 ? N / 2 - 1 : N / 2;
        int[] temp = Arrays.copyOf(nums, N);
        int index = 0;
        for (int i = 0; i <= mid; i++) {
            nums[index] = temp[mid - i];
            if (index + 1 < N) {
                nums[index + 1] = temp[N - 1 - i];
            }
            index += 2;
        }
    }
}