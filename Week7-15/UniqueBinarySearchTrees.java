public class UniqueBinarySearchTrees{
    //二叉树的种类是左子树*右子树的种类，因此可以用动态规划，当0，1时就一种，空间复杂度O(n)，时间复杂度O(n^2)
	public int numTrees(int n) {
        if(n<=0) return 0;
        int[] res=new int[n+1];
        res[0]=1;
        res[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                res[i]+=res[j]*res[i-j-1];
            }
        }
        return res[n];
    }
}