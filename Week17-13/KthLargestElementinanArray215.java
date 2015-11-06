public class Solution {
    /**
    * Using heap sort, it can delete max/min quickly, so just delete k times
    * Time O(nlogn), Space O(n) - auxiliary array
    */
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0) return -1;
        int[] newNums = new int[nums.length + 1];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        return sort(newNums, k);
    }
    private int sort(int[] nums, int k) {
        int N = nums.length - 1;
        for(int i = N/2; i >= 1; i--) sink(nums, i, N);
        int count = N - k + 1;
        while(N > count) {
            exch(nums, 1, N--);
            sink(nums, 1, N);
        }
        return nums[1];
    }
    private void sink(int[] nums, int i, int N) {
        while(2*i <= N) {
            int j = 2*i;
            if(j < N && less(nums, j, j+1)) j++;
            if(less(nums, i, j)) exch(nums, i, j);
            else break;
            i = j;
        }
    }
    private void exch(int[] nums, int i, int j) {
        nums[i] ^= nums[j]; nums[j] ^= nums[i]; nums[i] ^= nums[j];
    }
    private boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    //Use Priority Queue
     public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for(int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }

    //Index from 0 not 1, it can save space
    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        return sort(nums, k);
    }
    
    private int sort(int[] nums, int k) {
        int N = nums.length;
        for(int i = (N - 1) / 2; i >= 0; i--) sink(nums, i, N);
        int count = N - k + 1;
        while(N > count) {
            exch(nums, 0, --N);
            sink(nums, 0, N);
        }
        return nums[0];
    }
    
    private void sink(int[] nums, int i, int N) {
        while(2 * i + 1 < N) {
            int j = 2 * i + 1;
            if(j + 1 < N && less(nums, j, j + 1)) j++;
            if(less(nums, j, i)) break;
            exch(nums, i, j);
            i = j;
        }
    }
    
    private void exch(int[] nums, int i, int j) {
        nums[i] ^= nums[j]; nums[j] ^= nums[i]; nums[i] ^= nums[j];
    }
    private boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    //Select algorithm
    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int j = partition(nums, lo, hi);
            if(k - 1 == j) return nums[j];
            else if(k - 1 > j) lo = j + 1;
            else hi = j - 1;
        }
        return nums[k - 1];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = nums[lo];
        while(i < j) {
            while(nums[++i] >= pivot) if(i == hi) break;
            while(nums[--j] < pivot) if(j == lo) break;
            if(i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }
    
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}