class MedianFinder {

    private PriorityQueue<Integer> small; // maxheap
    private PriorityQueue<Integer> large; //minheap

    public MedianFinder() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.small.add(num);

        if(!this.small.isEmpty() && !this.large.isEmpty() && this.small.peek() > this.large.peek()) {
            this.large.add(this.small.poll());
        }

        if(this.small.size() > this.large.size() + 1) {
            this.large.add(this.small.poll());
        }

        if(this.large.size() > this.small.size()+1) {
            this.small.add(this.large.poll());
        }
    }
    
    public double findMedian() {
        if(this.small.size() > this.large.size()) {
            return (double)this.small.peek();
        } else if(this.large.size() > this.small.size()) {
            return (double)this.large.peek();
        }

        return ((double)this.small.peek() + this.large.peek())/2;
    }
}
