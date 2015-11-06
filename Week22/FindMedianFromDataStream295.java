class MedianFinder {
    private Queue<Long> large = new PriorityQueue<>();
    private Queue<Long> small = new PriorityQueue<>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if(large.size() < small.size()) large.add(-small.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(large.size() == 0 && small.size() == 0) return 0.0;
        return large.size() > small.size()? large.peek() : (large.peek() - small.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();