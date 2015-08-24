public class Solution {
    //k=(m+n)/2，题目等价于找到k处的值
    //因此每次在A，B数组中，都找k/2处的值，如A[k/2]==B[k/2]，则说明该处的值即为中位数
    //如果A[k/2]>B[k/2]则排除B的前k/2处的值，反之亦然
    //当k为1时，中位数为较小的值
    //时间复杂度，每次排除k/2即(m+n)/4,O(log(m+n)),空间复杂度O(1),递归主要是栈占空间
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null&&nums2==null) return 0.0;
        if((nums1.length+nums2.length)%2==1)
            return helper(nums1,0,nums1.length-1,nums2,0,nums2.length-1,(nums1.length+nums2.length)/2+1);
        else {
            return (helper(nums1,0,nums1.length-1,nums2,0,nums2.length-1,(nums1.length+nums2.length)/2+1)
                    +helper(nums1,0,nums1.length-1,nums2,0,nums2.length-1,(nums1.length+nums2.length)/2))/2;
        }
    }
    private double helper(int[] A,int i1,int i2,int[] B,int j1,int j2,int k){
        int m=i2-i1+1;
        int n=j2-j1+1;
        if(m>n)
            return helper(B,j1,j2,A,i1,i2,k);
        if(m==0){
            return B[j1+k-1];
        }
        if(k==1){
            return Math.min(A[i1],B[j1]);
        }
        int posA=Math.min(m,k/2);
        int posB=k-posA;
        if(A[i1+posA-1]==B[j1+posB-1]){
            return A[i1+posA-1];
        }
        else if(A[i1+posA-1]>B[j1+posB-1]){
            return helper(A,i1,i2,B,j1+posB,j2,k-posB);
        }else{
            return helper(A,i1+posA,i2,B,j1,j2,k-posA);
        }
    }
}