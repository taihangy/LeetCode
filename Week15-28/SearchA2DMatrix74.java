public class Solution {
    // time O(m + n), space O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row;
        for(row = 0; row < matrix.length; row++) {
            if(matrix[row][0] == target) return true;
            if(matrix[row][0] > target) break;
        }
        if(row != 0) row--;
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[row][i] == target) return true;
            else if(matrix[row][i] < target) continue;
            else return false;
        }
        return false;
    }

    // normal solution O(log(m * n))
    public boolean searchMatrix(int[][] matrix, int target) {
  		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
  		int start = 0, end = matrix.length * matrix[0].length - 1;
  		while(start <= end) {
  			int mid = (start + end) / 2;
  			int value = matrix[mid / matrix[0].length][mid % matrix[0].length];
  			if(target == value) return true;
  			else if (target < value) end = mid - 1;
  			else start = mid + 1;
  		}
  		return false;
    }
}