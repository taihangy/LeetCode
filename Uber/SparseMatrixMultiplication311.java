public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length != B[0].length || A[0].length != B.length) return null;
        int row = A.length, col = B[0].length;
        int[][] res = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int sum = 0;
                for(int k = 0; k < B.length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }
}

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A[0].length != B.length) return null;
        int m = A.length, n = B.length, l = B[0].length;
        int[][] res = new int[m][l];
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
        for(int i = 0; i < n; i++) {
            map.put(i, new HashMap<Integer, Integer>());
            for(int j = 0; j < l; j++) {
                if(B[i][j] != 0) {
                    map.get(i).put(j, B[i][j]);
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if(A[i][k] != 0) {
                    for(Integer j : map.get(k).keySet()) {
                        res[i][j] += A[i][k] * map.get(k).get(j);
                    }
                }
            }
        }
        return res;
    }
}