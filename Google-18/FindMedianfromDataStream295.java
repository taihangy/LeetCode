class MedianFinder {
    private Queue<Integer> left = new PriorityQueue<Integer>(100, (a, b) -> (b - a));
    private Queue<Integer> right = new PriorityQueue<Integer>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return left.size() > right.size() ? 
                left.peek() : (left.peek() + right.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();