class MedianFinder {
    private PriorityQueue<Integer> smallHalf; 
    
    private PriorityQueue<Integer> largeHalf; 
    public MedianFinder() {
        smallHalf = new PriorityQueue<>(Collections.reverseOrder());
         largeHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHalf.add(num);
        
        
        largeHalf.add(smallHalf.poll());
        
        
        if (smallHalf.size() < largeHalf.size()) {
            smallHalf.add(largeHalf.poll());
        }
    }
    
    public double findMedian() {
         
        if (smallHalf.size() > largeHalf.size()) {
            return smallHalf.peek();
        } 
        else {
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        }
    }
}
