public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || n == 0) return;
        if(m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int[] aux = new int[m];
        System.arraycopy(nums1, 0, aux, 0, m);
        int i = 0, j =0;
        for(int k = 0; k < m + n; k++) {
            if(i > m - 1) nums1[k] = nums2[j++];
            else if(j > n - 1) nums1[k] = aux[i++];
            else if(aux[i] <= nums2[j]) nums1[k] = aux[i++];
            else nums1[k] = nums2[j++];
        }
    }
}