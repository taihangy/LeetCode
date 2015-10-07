public class Solution {
    //O(m + n), space O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) return 0.0;
        int m = nums1.length, n = nums2.length;
        int[] aux = new int[m + n];
        int i = 0, j = 0;
        for(int k = 0; k < m + n; k++) {
            if(i >= m) aux[k] = nums2[j++];
            else if(j >= n) aux[k] = nums1[i++];
            else if(nums1[i] <= nums2[j]) aux[k] = nums1[i++];
            else aux[k] = nums2[j++];
        }
        if(aux.length % 2 == 1) return (double)aux[aux.length / 2];
        return (double)(aux[aux.length / 2] + aux[aux.length / 2 - 1]) / 2;
    }
}