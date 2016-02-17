class MedianFinder {
    private Queue<Integer> small = new PriorityQueue<Integer>(10, (a, b) -> (b - a));
    private Queue<Integer> big = new PriorityQueue<Integer>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        small.offer(num);
        big.offer(small.poll());
        if (small.size() < big.size()) small.offer(big.poll()); 
    }

    // Returns the median of current data stream
    public double findMedian() {
        return small.size() > big.size() ? small.peek() : (double) (small.peek() + big.peek()) / 2;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();