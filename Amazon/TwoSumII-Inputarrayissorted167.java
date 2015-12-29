public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) return new int[2];
        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            int first = numbers[i];
            int second = numbers[j];
            if(first + second == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }
            else if(first + second < target) {
                i++;
            } 
            else {
                j--;
            }
        }
        return res;
    }
}